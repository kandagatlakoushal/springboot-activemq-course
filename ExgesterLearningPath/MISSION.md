# Mission: Master the Exgester Codebase (S&P Global MI — Cappitech)

## Why
I now work at S&P Global Market Intelligence on the Cappitech project, maintaining **Exgester** — a Spring Boot, event-driven trade reporting engine that receives trade events over AMQ/JMS, decides reportability, determines regulatory regimes (EMIR, FCA, ASIC, CFTC, …), and builds regulatory submissions. It is built on Vavr `Either<L,R>` railway-oriented pipelines and multi-tenant Spring profiles (ANZ, WBC, Santander, Wells Fargo, …). I must be able to confidently read, modify, extend, and test this codebase.

## Success looks like
- Can read any Vavr `Either<L,R>` decision pipeline in Exgester and narrate exactly what happens on the success and failure tracks
- Can add a new decision step to a railway pipeline (with tests) without breaking the flow
- Can trace how a client-specific bean (e.g. an ANZ-only flow) gets selected via custom `@Profile` annotations and YAML config
- Can add a new client or a new regulatory regime by composing existing Strategy/Factory/Chain patterns
- Can write Cucumber BDD scenarios and JUnit tests for a decision pipeline, and read JaCoCo/Checkstyle output
- Can explain the full journey: AMQ message → listener → deserialization → decision engine → submission message → downstream queue
- Ships the capstone: **Mini-Exgester**, a working trade-reporting engine clone exercising every concept

## Constraints
- 1–2 hours per day, 5 weeks (30 sessions; ~40–55 hours total)
- Learns best project-based and infrastructure-first (see [NOTES.md](./NOTES.md))
- Already proficient: Spring Boot REST, databases, JMS/AMQ fundamentals (Lessons 1–7 of the AMQ course in the parent workspace)
- Cannot share proprietary Exgester code with the agent — lessons use a faithful open reconstruction (Mini-Exgester)

## Out of scope
- Kafka, Spring Cloud Stream
- Actual regulatory rulebook content (EMIR RTS field-level rules etc.) — we learn the *engineering patterns*, not compliance law
- Kubernetes/production deployment (Docker basics only, for local AMQ + app)
- Frontend, reporting UI
