package com.learningPath.springProfileAmq.NotificationHub.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListner {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "${app.queue.notification}")
    public void recieveNotification(String message) {
        log.info("Message Revieved : {}  ", message);
    }

}
