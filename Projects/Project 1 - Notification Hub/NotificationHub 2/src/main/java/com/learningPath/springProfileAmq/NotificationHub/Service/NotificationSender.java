package com.learningPath.springProfileAmq.NotificationHub.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationSender {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final JmsTemplate jmsTemplate;

    @Value("${app.queue.notification}")
    private String queueName;

    public NotificationSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(String message) {
        log.info("📤 Sending to [{}]: {}", queueName, message);
        jmsTemplate.convertAndSend(queueName, message);
        log.info("✅ Message sent successfully");

    }

}
