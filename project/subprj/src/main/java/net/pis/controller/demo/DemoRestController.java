package net.pis.controller.demo;

import lombok.extern.slf4j.Slf4j;
import net.pis.common.Direction;
import net.pis.common.JSONResponse;
import net.pis.common.JmsSender;
import net.pis.common.Listener;
import net.pis.controller.jms.JmsAdaptingController;
import net.pis.dto.DemoDTO;
import net.pis.message.MessageMetaInfo;
import net.pis.service.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by PARKIS on 2018-07-30.
 * Title : Rest 컨트롤러
 */

@RestController
@Slf4j
public class DemoRestController {

    @Autowired
    private DemoService demoService;

    // Test JMS Controller
    @Autowired
    private JmsAdaptingController jmsAdaptingController;


    @Autowired
    private JmsSender jmsSender;

    // Query DSL
    @RequestMapping(value = "/restdemo1", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity restDemo1(HttpServletRequest req, @RequestBody Map<String, Object> paramMap) {

        if (paramMap != null) {
            log.info("=== restdemo1 paramMap : " + paramMap.toString());
        }
        Map<String, Object> result = new HashMap<String, Object>();

        result = demoService.getList(paramMap);

        log.info("============restDemo==============");
        log.info("result : " + result.toString());

        return JSONResponse.getJSONResponse(req,result);
    }

    // JPA
    @RequestMapping(value = "/restdemo2", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity restDemo2(HttpServletRequest req, @RequestBody Map<String, Object> paramMap) {

        if (paramMap != null) {
            log.info("=== restdemo2 paramMap : " + paramMap.toString());
        }

        Map<String, Object> result = new HashMap<String, Object>();

        paramMap.put("id", "1");
        result = demoService.getListJPA(paramMap);

        log.info("============restDemo==============");
        log.info("result : " + result.toString());

        return JSONResponse.getJSONResponse(req,result);
    }

    // Mybatis
    @RequestMapping(value = "/restmybatis1", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity restMybatis1(HttpServletRequest req, @RequestBody Map<String, Object> paramMap) {

        if (paramMap != null) {
            log.info("=== restMybatis1 paramMap : " + paramMap.toString());
        }

        Map<String, Object> result = new HashMap<String, Object>();

        result = demoService.getNumTest(paramMap);

        log.info("============restMybatis1==============");
        log.info("result : " + result.toString());

        return JSONResponse.getJSONResponse(req,result);
    }

    // JMS 호출 테스트를 위한 리스트 호출
    @RequestMapping(value = "/getListToTestJMS", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity getListToTestJMS(HttpServletRequest req, @RequestBody Map<String, Object> paramMap) {

        if (paramMap != null) {
            log.info("=== getListToTestJMS paramMap : " + paramMap.toString());
        }

        Map<String, Object> result = new HashMap<String, Object>();

        List<DemoDTO> targetList = demoService.read();

        List<MessageMetaInfo> messageMetaInfoList = new ArrayList<>();

        try {
            for (DemoDTO interfaceDTO : targetList) {

                String uuid = UUID.randomUUID().toString();
                MessageMetaInfo metaInfo = new MessageMetaInfo();
                metaInfo.setMessageTagId(uuid);
                metaInfo.setMessageId("MESSAGE_ID_EXAMPLE_01");
                metaInfo.setDirection(Direction.Outbound);
                metaInfo.setDestination(Listener.Router);
                metaInfo.setAck(false);
                metaInfo.setError(false);
                metaInfo.setTargetSystemId("SYSTEM_ID_EXAMPLE_01");
                metaInfo.setTicket("TICKET_EXAMPLE_01");
                metaInfo.setErpSystem("NONSAP");

                messageMetaInfoList.add(metaInfo);

                // JMS 처리 가능한 Controller로 전송
                jmsAdaptingController.handleOutbound(metaInfo);
            }
            result.put("jmsList", messageMetaInfoList);
        } catch (Exception se ){
            log.info("DemoRestController SBMSException : " + se);
        }

        return JSONResponse.getJSONResponse(req,result);
    }

    // JMS 인바운드 호출 (SB -> Inbound Adaptor)
    @RequestMapping(value = "/sendMsgInbound", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity sendMsgInbound(HttpServletRequest req, @RequestBody Map<String, Object> paramMap) {

        if (paramMap != null) {
            log.info("=== sendMsgInbound paramMap : " + paramMap.toString());
        }

        Map<String, Object> result = new HashMap<String, Object>();

        List<DemoDTO> targetList = demoService.read();
        DemoDTO DemoDTO = (DemoDTO) targetList.get(0);

        MessageMetaInfo metaInfo = null;
        boolean sendResult = false;

        try {
            String uuid = UUID.randomUUID().toString();
            metaInfo = new MessageMetaInfo();
            metaInfo.setMessageTagId(uuid);
            metaInfo.setMessageId("MESSAGE_ID_EXAMPLE_01");
            // 인바운드 Router로 보낸다
            metaInfo.setDirection(Direction.Inbound);
            metaInfo.setDestination(Listener.Router);
            metaInfo.setAck(true);
            metaInfo.setError(false);
            metaInfo.setTargetSystemId("SYSTEM_ID_EXAMPLE_01");
            metaInfo.setTicket("TICKET_EXAMPLE_01");
            metaInfo.setErpSystem("NONSAP");

            // JMS 처리 가능한 Controller로 메시지 전송
            jmsSender.sendMessage(metaInfo);

            sendResult = true;
        } catch (JMSException je) {
            log.info("DemoRestController JMSException : " + je);
            sendResult = false;
        } finally {
            result.put("sendResult", sendResult);
        }

        return JSONResponse.getJSONResponse(req,result);
    }
}
