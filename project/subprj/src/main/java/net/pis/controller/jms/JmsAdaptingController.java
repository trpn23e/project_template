/*
 * (c)BOC
 */
package net.pis.controller.jms;

import net.pis.message.MessageMetaInfo;
import net.pis.service.jms.JmsAdaptingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * 어댑팅 컨트롤러
 */
@Controller
@ManagedResource
public class JmsAdaptingController implements MessageListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JmsAdaptingService adaptingService;

    /**
     * 인바운드 데이타 컨트롤러
     *
     * @param messageMetaInfo
     */
    public void handleInbound(MessageMetaInfo messageMetaInfo) {

        logger.info("==== 2. JmsAdaptingController.handleInbound() 진입 ========");
        logger.info("==== JmsAdaptingController << Inbound  handling is stared! <<");
        logger.info("==== JmsAdaptingController << traget MetaInfo \n{}\n", messageMetaInfo);

        long ctm = System.currentTimeMillis();

        try {

            adaptingService.adapt(messageMetaInfo);

        } catch (Exception ae) {
            logger.error(ae.getMessage());
        } finally {
        }

        logger.info("==== JmsAdaptingController << Inbound handling is completed! <<");

    }


    /**
     * 아웃바운드 데이타 컨트롤러
     *
     * @param messageMetaInfo
     */
    public void handleOutbound(MessageMetaInfo messageMetaInfo) throws Exception{

        logger.info("==== 2. JmsAdaptingController.handleOutbound() 진입 ========");
        logger.info("= Description : PollingTaskService를 통해 Interface 테이블을 조회");
        logger.info("= 해서 얻은 결과를 가지고 처리할때는 OutBound 처리가 된다.");
        logger.info("= (데이터 처리가 이뤄지는 첫 단계임");
        logger.info("===================================================================");
        logger.info("===== JmsAdaptingController >> Outbound handling is stared! >>");
        logger.info("===== JmsAdaptingController >> target MetaInfo \n{}\n", messageMetaInfo);

        adaptingService.adapt(messageMetaInfo);

        logger.info("===== JmsAdaptingController >> Outbound handling is completed! >>");

    }

    /**
     * JMS Listener
     *
     * @param message
     */
    @Override
    public void onMessage(Message message
    ) {
        logger.info("JmsAdaptingController onMessage =============================================== ");
        if (message instanceof ObjectMessage) {

            ObjectMessage om = (ObjectMessage) message;

            try {
                MessageMetaInfo messageMetaInfo = (MessageMetaInfo) om.getObject();
                this.handleInbound(messageMetaInfo);

            } catch (Exception e) {
                logger.error("{}", e);
            }

        } else {
            logger.info(message.toString());
        }

    }
}
