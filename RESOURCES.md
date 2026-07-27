# Spring Boot + ActiveMQ Resources

## Knowledge

### Official Documentation (Highest Trust)
- [Spring Boot Messaging — JMS Reference](https://docs.spring.io/spring-boot/reference/messaging/jms.html)
  The definitive reference for Spring Boot's JMS auto-configuration, connection factories, and listener containers. Use for: any question about how Spring Boot wires up JMS.

- [Spring Boot Profiles Reference](https://docs.spring.io/spring-boot/reference/features/profiles.html)
  Official docs on `@Profile`, profile-specific properties files, profile groups, and activation methods. Use for: anything about environment-specific configuration.

- [Spring Guide: Messaging with JMS](https://spring.io/guides/gs/messaging-jms/)
  Official getting-started guide. Walks through a complete producer-consumer example with an embedded ActiveMQ broker. Use for: first-time setup and basic patterns.

- [Apache ActiveMQ Artemis Documentation](https://activemq.apache.org/components/artemis/documentation/)
  Broker-side documentation. Addresses, queues, security, persistence, clustering. Use for: understanding what happens inside the broker.

- [Apache ActiveMQ Classic — Getting Started](https://activemq.apache.org/getting-started)
  Legacy broker setup. Use for: understanding Classic if encountered in interviews.

### High-Quality Tutorials
- [Baeldung: Spring with JMS and ActiveMQ](https://www.baeldung.com/spring-remoting-jms)
  Well-maintained tutorial covering JmsTemplate, @JmsListener, message converters. Use for: bridging official docs with practical code patterns.

- [Baeldung: Spring Profiles](https://www.baeldung.com/spring-profiles)
  Comprehensive guide to @Profile annotation, profile-specific properties, and programmatic activation. Use for: practical profile configuration patterns.

### Reference Documentation
- [JMS 2.0 Specification (JSR 343)](https://jcp.org/en/jsr/detail?id=343)
  The underlying standard. Use for: understanding what JMS guarantees vs. what is broker-specific.

- [Jakarta Messaging 3.1 (Spring Boot 3)](https://jakarta.ee/specifications/messaging/3.1/)
  Jakarta EE successor to JMS. Use for: understanding namespace changes (javax → jakarta) in Spring Boot 3.

## Wisdom (Communities)

- [r/java](https://reddit.com/r/java)
  Active Java community. Good for architecture debates and real-world experience reports. Use for: validating design decisions.

- [Stack Overflow — [spring-jms] tag](https://stackoverflow.com/questions/tagged/spring-jms)
  High-quality Q&A. Use for: troubleshooting specific integration issues.

- [Spring Community Forums](https://github.com/spring-projects/spring-boot/discussions)
  GitHub Discussions for Spring Boot. Use for: edge cases and direct maintainer feedback.

## Gaps
- No public information on S&P Global MI's specific ActiveMQ version or configuration patterns. Covering both Classic and Artemis to be safe.
