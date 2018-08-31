/*
 * (c)BOC
 */
package net.pis.service.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.pis.common.JmsSender;
import net.pis.message.MessageMetaInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.ws.rs.WebApplicationException;
import javax.xml.ws.WebServiceException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
//@Scope(scopeName = "prototype")
@ManagedResource
public class JmsConnectingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void arrivedJmsMsg(MessageMetaInfo messageMetaInfo) {

        logger.info("JmsConnectingService messageMetaInfo {}", messageMetaInfo);
        logger.info("==== Outbound Adapt -> Route -> Connector JMS send처리 끝 후처리는 나름대로~ ");
    }

}
