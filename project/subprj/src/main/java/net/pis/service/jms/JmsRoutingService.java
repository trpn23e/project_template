/**
 * (c)BOC
 */
package net.pis.service.jms;

import net.pis.common.JmsSender;
import net.pis.common.Listener;
import net.pis.message.MessageMetaInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.jms.JMSException;

@Service
//@Scope(scopeName = "prototype")
public class JmsRoutingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JmsSender jmsSender;

    public void route(MessageMetaInfo messageMetaInfo) throws Exception {
        logger.info("=== 10. JmsRoutingService.route() 진입 =============");

        try {

            switch (messageMetaInfo.getDirection()) {
                case Inbound: {
                    logger.info("=== JmsRoutingService.route() inbound case 진입 =============");
                    messageMetaInfo.setDestination(Listener.Adapter);
                    jmsSender.sendMessage(messageMetaInfo);

                    break;
                }
                case Outbound: {
                    logger.info("=== 11. Connector로 전달 =============");
                    messageMetaInfo.setDestination(Listener.Connector);
                    jmsSender.sendMessage(messageMetaInfo);

                    break;
                }
                default: {
                    throw new Exception("=== 라우팅 방향 없음 오류 ===");
                }
            }

        } catch (JMSException je) {
            logger.error("{}", je);
        }catch (Exception e) {
            logger.error("{}", e);
        }

    }
}
