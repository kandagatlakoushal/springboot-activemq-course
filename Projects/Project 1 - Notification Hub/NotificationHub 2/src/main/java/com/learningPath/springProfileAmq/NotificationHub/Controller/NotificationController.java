package com.learningPath.springProfileAmq.NotificationHub.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningPath.springProfileAmq.NotificationHub.Service.NotificationSender;
import com.learningPath.springProfileAmq.NotificationHub.model.NotificationMessage;

import java.time.Instant;
import java.util.UUID;

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

    public record NotificationRequest(String recipient, String content) {
    }

    @PostMapping("/notify")
    public ResponseEntity<NotificationMessage> notify(@RequestBody NotificationRequest request) {

        // Create a structured domain object
        String alertId = "ALT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        // Added 'null' as the 5th argument for the timestamp field to match the
        // constructor
        NotificationMessage msg = new NotificationMessage(alertId, request.recipient(), request.content(), "DISPATCHED",
                Instant.now().toString());

        sender.send(msg);
        return ResponseEntity.ok(msg);
    }

}