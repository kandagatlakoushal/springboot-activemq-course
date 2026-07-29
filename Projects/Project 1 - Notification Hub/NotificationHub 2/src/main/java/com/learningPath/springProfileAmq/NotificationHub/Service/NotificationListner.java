package com.learningPath.springProfileAmq.NotificationHub.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.learningPath.springProfileAmq.NotificationHub.model.NotificationMessage;

@Service
public class NotificationListner {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "${app.queue.notification}")
    public void recieveNotification(NotificationMessage message) {
        // The message parameter is already deserialized from JSON back into a Java
        // POJO!
        log.info("📥 Received Deserialized POJO:");
        log.info("   ├─ ID:        {}", message.getId());
        log.info("   ├─ To:        {}", message.getRecipient());
        log.info("   ├─ Content:   {}", message.getContent());
        log.info("   └─ Timestamp: {}", message.getTimestamp());
    }

}
