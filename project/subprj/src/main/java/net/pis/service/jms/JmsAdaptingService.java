package net.pis.service.jms;

import net.pis.common.*;
import net.pis.message.MessageMetaInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.util.Calendar;
import java.util.UUID;

@Service
public class JmsAdaptingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected JmsSender jmsSender;


    /**
     * 인바운드 데이타 처리
     *
     * @param messageMetaInfo
     */
    private void adaptInbound(MessageMetaInfo messageMetaInfo) throws Exception {
        logger.info("JmsAdaptingService adaptInbound =============================================== ");
        logger.info("=== 끝~ 후처리는 나름대로 작성 ~ ====");

    }

    private void adaptOutbound(MessageMetaInfo messageMetaInfo) throws Exception {

        logger.info("===== 3.JmsAdaptingService.adaptOutBound() =====");
        logger.info("= Description : 라우터로 jms send =");
        logger.info("=======================================================");
        logger.info("===== JmsAdaptingService adaptOutbound =============================================== ");

        try {
            messageMetaInfo.setDirection(Direction.Outbound);
            messageMetaInfo.setDestination(Listener.Router);

            jmsSender.sendMessage(messageMetaInfo);

        } catch (JMSException e) {
            logger.info(e.toString());
        }
    }

    public void adapt(MessageMetaInfo messageMetaInfo) throws Exception {
        logger.debug("============= JmsAdaptingService.adapt() ====================");

        if (null != messageMetaInfo.getDirection()) {

            switch (messageMetaInfo.getDirection()) {
                case Outbound: {
                    this.adaptOutbound(messageMetaInfo);
                    break;
                }
                case Inbound: {
                    this.adaptInbound(messageMetaInfo);
                    break;
                }
            }
        }
        logger.debug("END ADAPTING");
    }

}
