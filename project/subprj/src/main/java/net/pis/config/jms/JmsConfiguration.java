/*
 * (c)BOC
 */
package net.pis.config.jms;

import org.apache.activemq.pool.PooledConnectionFactory;
import net.pis.common.JmsSender;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;
import javax.jms.Queue;

/**
 * ActiveMQ 임베디드 브로커 & 컨테이너 설정
 */
@Configuration
@EnableJms
public class JmsConfiguration {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String DEFAULT_LISTENER_METHOD = "onMessage";

    // 오류로 표시는 되지만 돌아는 간다..
    @Autowired
    @Lazy
    private MessageListener jmsRoutingController;
    
    // 오류로 표시는 되지만 돌아는 간다..
    @Autowired
    @Lazy
    private MessageListener jmsAdaptingController;

    // 오류로 표시는 되지만 돌아는 간다..
    @Autowired
    private MessageListener jmsConnectingController;

    @Value("${jms.url}")
    private String jmsUri;

    @Value("${sbms.jms.consumer:3}")
    private Integer jmsConsumer;

    @Bean
    public JmsSender jmsSender() {
        final JmsSender sender = new JmsSender();
        sender.setJmsTemplate((JmsTemplate) jmsTemplate());

        return sender;
    }

    @Bean
    public BrokerService brokerService() throws Exception {
        BrokerService broker = new BrokerService();
        broker.addConnector(jmsUri);
        broker.setPersistent(false);
        //broker.start();

        return broker;
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(jmsUri);
        factory.setTrustAllPackages(true);
        factory.setObjectMessageSerializationDefered(true);

        return factory;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        PooledConnectionFactory factory = new PooledConnectionFactory(activeMQConnectionFactory());
        return factory;
    }

    @Bean
    public Queue listenQueueRouter() {
        return new ActiveMQQueue("Router");
    }

    @Bean
    public Queue listenQueueAdapter() {
        return new ActiveMQQueue("Adapter");
    }

    @Bean
    public Queue listenQueueConnector() {
        return new ActiveMQQueue("Connector");
    }

    @Bean
    public JmsOperations jmsTemplate() {
        final JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        return jmsTemplate;
    }

    @Bean
    public MessageListenerAdapter adaptingAdapter() {
        final MessageListenerAdapter adapter = new MessageListenerAdapter(jmsAdaptingController);
        adapter.setDefaultListenerMethod(DEFAULT_LISTENER_METHOD);
        return adapter;

    }

    @Bean
    public MessageListenerAdapter routingAdapter() {
        final MessageListenerAdapter adapter = new MessageListenerAdapter(jmsRoutingController);
        adapter.setDefaultListenerMethod(DEFAULT_LISTENER_METHOD);
        return adapter;

    }

    @Bean
    public MessageListenerAdapter connectingAdapter() {
        final MessageListenerAdapter adapter = new MessageListenerAdapter(jmsConnectingController);
        adapter.setDefaultListenerMethod(DEFAULT_LISTENER_METHOD);
        return adapter;
    }


    @Bean
    public DefaultMessageListenerContainer defaultMessageListenerContainerForAdapter() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setMessageListener(adaptingAdapter());
        container.setDestination(listenQueueAdapter());
        container.setConcurrentConsumers(jmsConsumer);
        return container;
    }

    @Bean
    public DefaultMessageListenerContainer defaultMessageListenerContainerForRouter() {

        logger.info(">>>>> 기본 컨슈머 수  : {} <<<<<<", jmsConsumer);

        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setMessageListener(routingAdapter());
        container.setDestination(listenQueueRouter());
        container.setConcurrentConsumers(jmsConsumer);
        return container;
    }


    @Bean
    public DefaultMessageListenerContainer defaultMessageListenerContainerForConnector() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setMessageListener(connectingAdapter());
        container.setDestination(listenQueueConnector());
        container.setConcurrentConsumers(jmsConsumer);

        return container;
    }


}
