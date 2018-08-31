/*
 * (c)BOC
 */
package net.pis.service.schedule;

import net.pis.common.Direction;
import net.pis.common.Listener;
import net.pis.controller.jms.JmsAdaptingController;
import net.pis.dto.DemoDTO;
import net.pis.message.MessageMetaInfo;
import net.pis.service.demo.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * 잡 클래스
 */
@Service
@ManagedResource
// @Conditional(PollingCondition.class)
public class PollingTaskService implements PollingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JmsAdaptingController jmsAdaptingController;

    @Autowired
    private DemoService demoService;

    private Integer callCount = 0;

    @ManagedAttribute(description = "hello")
    public Integer getCallCount() {
        return callCount;
    }


    private List<MessageMetaInfo> grapTargets() {

        List<DemoDTO> targetList = demoService.read();

        List<MessageMetaInfo> messageMetaInfoList = new ArrayList<>();

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

            metaInfo.setErpSystem("NONSAP"); // NONSAP으로 고정하자 signal 셋팅

            messageMetaInfoList.add(metaInfo);
        }

        return messageMetaInfoList;
    }

    @Override
    public List<?> execute() {
        return null;
    }

    @Override
    @ManagedAttribute
    @ManagedOperation(description = "헬로")
    public List<MessageMetaInfo> execute2() {
        callCount++;

        List<MessageMetaInfo> metaInfoList = new ArrayList<>();

        try {
            metaInfoList.addAll(this.grapTargets());
        } catch (Exception e) {
            logger.error("{}", e.toString());
        }

        return metaInfoList;

    }

    @Override
    public void execute3() {

    }

    /**
     * Quartz 스케쥴러 시작 매서드
     */
    @Scheduled(fixedDelay = 10000, initialDelay = 5000)
    public void poll() {

        logger.info("=============================================");
        logger.info("= 1.polling 시작(PollingTaskService.poll()");
        logger.info("=============================================");

        List<MessageMetaInfo> metaInfoList = this.execute2();
        logger.info("1.PollingTaskService.poll() metaInfoList : " + metaInfoList.toString());

        for (MessageMetaInfo messageMetaInfo : metaInfoList) {

            try {
                jmsAdaptingController.handleOutbound(messageMetaInfo);
            } catch (Exception se) {
                logger.error(se.getMessage());
            }

        }
        logger.info("*****========================================*****");
        logger.info("= 1.polling 종료(PollingTaskService.poll()");
        logger.info("*****========================================*****");

    }

}
