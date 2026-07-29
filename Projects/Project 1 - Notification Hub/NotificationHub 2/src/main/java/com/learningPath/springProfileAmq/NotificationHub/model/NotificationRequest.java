package com.learningPath.springProfileAmq.NotificationHub.model;

import lombok.Data;

@Data
public class NotificationRequest {
    String recipient;
    String content;

}
