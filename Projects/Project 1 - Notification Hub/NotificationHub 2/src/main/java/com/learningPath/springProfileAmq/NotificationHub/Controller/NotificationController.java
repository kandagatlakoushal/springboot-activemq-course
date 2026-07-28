package com.learningPath.springProfileAmq.NotificationHub.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningPath.springProfileAmq.NotificationHub.Service.NotificationSender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/app")
public class NotificationController {
    private final Logger log = LoggerFactory.getLogger(this.getClass().toString());
    public NotificationSender sender;

    public NotificationController(NotificationSender sender) {
        this.sender = sender;
    }

    @PostMapping("/notify")
    public ResponseEntity<String> notify(@RequestBody String message) {
        sender.send(message);
        return ResponseEntity.ok("Notification sent: " + message);
    }

}