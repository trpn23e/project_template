/**
 * (c)BOC
 */
package net.pis.common;

import net.pis.message.MessageMetaInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.io.Serializable;

public class JmsSender {

    private JmsTemplate jmsTemplate_i;

    /**
     * Sends message using JMS Template.
     *
     * @param destination
     * @param message_p   the message_p
     * @throws javax.jms.JMSException the jMS exception
     */
    public void sendMessage(String destination, Serializable message_p) throws JMSException {

        jmsTemplate_i.send(destination, new ObjectMessageCreator(message_p));
    }

    public void sendMessage(String destination, String message_p) throws JMSException {
        jmsTemplate_i.send(destination, new TextMessageCreator(message_p));
    }

    public void sendMessage(Serializable message_p) throws JMSException {

        logger.info("=== 7. JmsSender.sendMessage() 진입 ===");
        logger.info("=== Description : 설정된 Queue이름으로 메시지 데이터를 JmsTemplate이 전송한다.");
        MessageMetaInfo messageMetaInfo = (MessageMetaInfo) message_p;

        logger.info(" ==== messageMetaInfo.getDestination().name() : " + messageMetaInfo.getDestination().name());
        logger.info("=======================================");

        jmsTemplate_i.send(messageMetaInfo.getDestination().name(), new ObjectMessageCreator(message_p));

    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Sets the jms template.
     *
     * @param tmpl
     */
    public void setJmsTemplate(JmsTemplate tmpl) {
        this.jmsTemplate_i = tmpl;
    }

    class ObjectMessageCreator implements MessageCreator {

        Serializable data;

        ObjectMessageCreator(Serializable data) {
            this.data = data;
        }

        @Override
        public Message createMessage(Session session) throws JMSException {

            ObjectMessage message = session.createObjectMessage();

            logger.trace("{}", message.toString());

            message.setObject(data);

            return message;
        }
    }

    class TextMessageCreator implements MessageCreator {

        String data;

        TextMessageCreator(String data) {
            this.data = data;
        }

        @Override
        public Message createMessage(Session session) throws JMSException {

            logger.error("{}", data);

            TextMessage message = session.createTextMessage();
            message.setText(data);

            return message;
        }
    }

}
