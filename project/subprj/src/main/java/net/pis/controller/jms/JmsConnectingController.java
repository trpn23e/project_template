/*
 * (c)BOC
 */
package net.pis.controller.jms;

import net.pis.message.MessageMetaInfo;
import net.pis.service.jms.JmsConnectingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Controller
public class JmsConnectingController implements MessageListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JmsConnectingService jmsConnectingService;

    public void handleInbound(MessageMetaInfo messageMetaInfo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void handleOutbound(MessageMetaInfo messageMetaInfo) {

        logger.debug(">> Outbound handling is stared! >>");
        logger.debug(">> traget MetaInfo \n{}\n", messageMetaInfo);

        try {

            jmsConnectingService.arrivedJmsMsg(messageMetaInfo);

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.debug(">> Outbound handling is completed! >>");

    }

    /**
     * JMS 메세지 수신
     * <p>
     * Router에서 넘어온 메세지를 수신하여 처리한다.
     *
     * @param message
     */
    @Override
    public void onMessage(Message message) {

        if (message instanceof ObjectMessage) {

            ObjectMessage om = (ObjectMessage) message;

            try {
                MessageMetaInfo messageMetaInfo = (MessageMetaInfo) om.getObject();

                this.handleOutbound(messageMetaInfo);

            } catch (JMSException e) {
                logger.error(e.getMessage());
            }

        } else {
            logger.debug(message.toString());
        }

    }
}
