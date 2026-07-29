package com.learningPath.springProfileAmq.NotificationHub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationMessage {
    private String id;
    private String recipient;
    private String content;
    private String status;
    private String timestamp;
}
// Triggers IDE recompile
