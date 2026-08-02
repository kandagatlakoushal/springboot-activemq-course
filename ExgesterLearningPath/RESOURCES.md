# Exgester Learning Path Resources

High-trust sources for lessons in this path. Lessons must cite from here, not from parametric memory.

## Knowledge

### Vavr & Railway-Oriented Programming (Week 2 — most important)
- [Vavr Official User Guide](https://docs.vavr.io/)
  The canonical guide: Option, Try, Either, Validation, collections, property checking. Use for: any Vavr API question — always check here first.
- [Vavr Either Javadoc](https://javadoc.io/doc/io.vavr/vavr/latest/io/vavr/control/Either.html)
  Exact method signatures and semantics (right-bias, map/flatMap/fold/peek/swap). Use for: signature-reading drills and API precision.
- [Railway Oriented Programming — Scott Wlaschin (talk + article)](https://fsharpforfunandprofit.com/rop/)
  THE origin of the two-track mental model Exgester pipelines are built on. F# syntax, universal ideas. Use for: Session 7 & 10 conceptual grounding.
- [Baeldung: Guide to Either in Vavr](https://www.baeldung.com/vavr-either)
  Practical Java-first Either patterns. Use for: bridging Wlaschin's theory to Java code.
- [Baeldung: Introduction to Vavr](https://www.baeldung.com/vavr)
  Tour of Option/Try/Tuple/collections. Use for: Session 8.
- [Baeldung: Vavr Validation API](https://www.baeldung.com/vavr-validation-api)
  Error-accumulating validation vs short-circuiting Either. Use for: Session 11.

### Modern Java (Week 1)
- [Oracle Java Tutorials — Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
  First-party generics coverage incl. bounded types & wildcards. Use for: Session 2 theory.
- [Oracle Java Tutorials — Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
  First-party lambdas & functional interfaces. Use for: Session 3.
- [java.util.stream Javadoc (package summary)](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/package-summary.html)
  Authoritative stream semantics: laziness, ordering, side-effect rules. Use for: Session 4.
- [Book: _Effective Java_, 3rd ed. — Joshua Bloch](https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/)
  Items on immutability (Item 17), builders (Item 2), generics (Items 26–33), lambdas/streams (Items 42–48). Use for: Sessions 1–6 depth; the single best Java book for this path.

### Design Patterns (Week 3)
- [Refactoring Guru — Design Patterns](https://refactoring.guru/design-patterns)
  Clear, illustrated catalog with Java examples for Strategy, Factory, Template Method, Chain, Composite, Builder. Use for: Week 3 primary reading.
- [Book: _Head First Design Patterns_, 2nd ed.](https://www.oreilly.com/library/view/head-first-design/9781492077992/)
  Gentler narrative treatment if Refactoring Guru feels terse. Use for: alternative angle on Strategy/Template.

### Spring Boot & Configuration (Week 4)
- [Spring Framework Reference — The IoC Container](https://docs.spring.io/spring-framework/reference/core/beans.html)
  Authoritative on DI, bean lifecycle, @Configuration/@Bean, qualifiers. Use for: Session 19.
- [Spring Boot Reference — Profiles](https://docs.spring.io/spring-boot/reference/features/profiles.html)
  @Profile, profile groups, activation. Use for: Session 20.
- [Spring Framework — @Profile with composed annotations](https://docs.spring.io/spring-framework/reference/core/beans/environment.html#beans-definition-profiles-java)
  Shows building custom meta-annotations like `@Production` — the exact pattern behind Exgester's client annotations. Use for: Session 20 custom `@AnzProfile` build.
- [Spring Boot Reference — Externalized Configuration](https://docs.spring.io/spring-boot/reference/features/external-config.html)
  YAML layering, property precedence, @ConfigurationProperties binding. Use for: Session 21.
- [Spring Boot Reference — Messaging (JMS)](https://docs.spring.io/spring-boot/reference/messaging/jms.html)
  JMS auto-configuration, listener containers. Use for: Session 23 (continuity with parent AMQ course).

### Jackson & Lombok
- [Jackson Databind — GitHub docs](https://github.com/FasterXML/jackson-databind#readme)
  First-party ObjectMapper usage and annotations entry point. Use for: Session 22.
- [Baeldung: Jackson Annotation Examples](https://www.baeldung.com/jackson-annotations)
  Practical @JsonProperty/@JsonInclude/@JsonTypeInfo catalog. Use for: Session 22 reference.
- [Project Lombok — Feature Overview](https://projectlombok.org/features/)
  First-party docs for @Value, @Builder, @Jacksonized. Use for: Sessions 1, 14, 22.

### Testing & Quality (Week 5)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
  Authoritative on parameterized/nested tests, lifecycle. Use for: Session 25.
- [AssertJ Documentation](https://assertj.github.io/doc/)
  Fluent assertions incl. the vavr-assert module. Use for: Session 25.
- [Mockito Documentation](https://site.mockito.org/)
  Mocking edges (JMS senders, clocks). Use for: Session 25.
- [Cucumber Documentation — Guides](https://cucumber.io/docs/cucumber/)
  Gherkin, step definitions, cucumber-spring integration. Use for: Session 26.
- [Maven — Introduction to the Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)
  Phases and plugin binding. Use for: Session 27.
- [JaCoCo Documentation](https://www.jacoco.org/jacoco/trunk/doc/)
  Coverage counters, maven plugin, check rules. Use for: Session 27.
- [Checkstyle Documentation](https://checkstyle.org/)
  Rules and maven integration. Use for: Session 27.
- [Docker — Get Started Guide](https://docs.docker.com/get-started/)
  Images/containers/compose fundamentals. Use for: Session 28.

### Domain Context (background reading, not sessions)
- [S&P Global — Cappitech Regulatory Reporting](https://www.spglobal.com/market-intelligence/en/solutions/regulatory-compliance-and-reporting)
  What the product does commercially; grounds the "why" of Exgester. Use for: mission context.
- [ESMA — EMIR Reporting](https://www.esma.europa.eu/data-reporting/emir-reporting)
  What EMIR trade reporting actually is. Use for: understanding regime vocabulary (UTI, LEI, counterparty).

## Wisdom (Communities)

- Your Cappitech/Exgester team — code reviews, design discussions, senior engineers
  The highest-value community you have. Use for: validating that Mini-Exgester patterns match real Exgester idioms; ask "does our pipeline do it this way?"
- [Stack Overflow — [vavr] tag](https://stackoverflow.com/questions/tagged/vavr)
  Maintainer-answered Vavr questions. Use for: Either/Try edge cases.
- [r/java](https://reddit.com/r/java)
  Architecture debates, FP-in-Java experience reports. Use for: sanity-checking design instincts.
- [Spring Boot GitHub Discussions](https://github.com/spring-projects/spring-boot/discussions)
  Direct maintainer feedback. Use for: profile/config edge cases.

## Gaps
- No public resource describes Exgester's internal architecture — Mini-Exgester is our reconstruction; validate its shapes against the real codebase with your team.
- Vavr is in maintenance mode (1.0 long in beta); watch for your team's version and pin lessons to it once known (note it in NOTES.md).
