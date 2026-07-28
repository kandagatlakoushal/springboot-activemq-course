# Lessons 1 & 2 Concepts Mastered

The user demonstrated complete retrieval of all core concepts from Lessons 1 and 2 via a 10-question grill session (10/10 correct). Key understandings verified:

- **Infrastructure mental model**: Can explain decoupling as knowledge + temporal coupling elimination, not just "separate servers." Knows that the broker is a separate process with its own host:port, messages persist on disk, and consumers process backlogs when they recover.
- **JMS specification vs implementation**: Correctly uses the JDBC analogy. Knows JSR 343 / Jakarta Messaging.
- **6 JMS objects hierarchy**: Knows ConnectionFactory → Connection → Session → Producer/Consumer + Destination. Knows Session is NOT thread-safe (common interview question).
- **ConnectionFactory is lazy**: Understands it holds config but doesn't open a TCP connection until a message operation occurs.
- **JmsTemplate lifecycle**: Can walk through the full sequence (Connection → Session → Producer → send → close) and knows why CachingConnectionFactory is needed in production.
- **Artemis Addresses**: Knows anycast = Queue, multicast = Topic.
- **Deployment topology**: Can explain dev (embedded/Docker) vs prod (clustered/managed) and connect it to Spring Profiles.

### Implications
All Lesson 1 & 2 concepts are at storage strength. Lesson 3 can proceed without review — the user is ready to write code against a running broker.
