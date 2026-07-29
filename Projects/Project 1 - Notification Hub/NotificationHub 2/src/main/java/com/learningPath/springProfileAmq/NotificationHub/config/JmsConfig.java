package com.learningPath.springProfileAmq.NotificationHub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {

        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();

        // 1. Tell converter to wrap JSON in a jakarta.jms.TextMessage (not
        // BytesMessage)
        converter.setTargetType(MessageType.TEXT);

        // 2. Set the custom JMS header property name that will store the Java class
        // name
        converter.setTypeIdPropertyName("_type");

        return converter;
    }
}