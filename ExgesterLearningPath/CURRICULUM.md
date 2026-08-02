# Exgester Mastery Curriculum — 5 Weeks, 30 Sessions

> **Goal:** master every concept needed to modify and maintain Exgester — a Spring Boot, event-driven,
> multi-tenant trade reporting engine built on Vavr railway-oriented pipelines.
> **Cadence:** 6 sessions/week × 1–2 h. Day 7 each week is rest/overflow.
> **Method:** every session = ① retrieval warm-up (10 min) → ② lesson (20–30 min) → ③ hands-on build (45–60 min) → ④ self-grill (10 min).
> Lessons are authored one at a time by the agent as you progress (see [INSTRUCTION-MANUAL.md](./INSTRUCTION-MANUAL.md)); this file is the syllabus, not the lessons.

## The Capstone: Mini-Exgester

Everything converges on one project you build incrementally from Week 2 onward:

```
Trade Event (JSON on AMQ queue)
      │
      ▼
@JmsListener → Jackson deserialization → TradeEvent (immutable)
      │
      ▼
Decision Engine  (Vavr Either<RejectionReason, ReportableTrade> railway)
  ├─ EligibilityCheck        — must this trade be reported at all?
  ├─ RegimeDetermination     — EMIR? FCA? ASIC? CFTC? (Strategy + Chain)
  ├─ Enrichment              — add LEI, UTI, venue data
  └─ Validation              — composite field rules
      │
      ├─ Left(reason)  → rejection queue + audit log
      ▼
SubmissionFactory (per-regime Factory + Builder)
      │
      ▼
JmsTemplate → regulatory.submission.<regime> queue
```

Multi-tenant from Week 4: the same engine serves `anz`, `wbc`, `santander`, `wellsfargo` via custom
profile annotations and per-client YAML.

---

## Week 1 — Modern Java: the Language of Exgester

*Why first: you cannot read a Vavr pipeline without fluency in generics, lambdas, and immutability. Every Exgester model class and pipeline signature uses these.*

### Session 1 — Immutability & Value Objects
- `final` fields, defensive copies, no setters; why immutability is non-negotiable in event-driven systems (messages are facts — facts don't change)
- Java records vs Lombok `@Value` / `@Builder` — what Exgester-style codebases use and why
- **Build:** `TradeEvent` as an immutable value object, three ways (plain final class, record, Lombok)
- **Exgester tie-in:** every message payload class you'll ever touch is one of these

### Session 2 — Generics Deep Dive
- Type parameters, bounded types (`<T extends Comparable<T>>`), wildcards, PECS (`? extends` / `? super`)
- Reading gnarly signatures: `<L, R, U> Either<L, U> flatMap(Function<? super R, Either<L, ? extends U>>)`
- **Build:** write a tiny `Result<E, V>` container yourself (you'll throw it away when Vavr arrives — but you'll *understand* Either forever)
- **Exgester tie-in:** decoding pipeline method signatures at a glance

### Session 3 — Lambdas & Functional Interfaces
- `Function`, `Predicate`, `Supplier`, `Consumer`, `BiFunction`; method references
- Composition: `andThen`, `compose`, `Predicate.and/or/negate`
- **Build:** compose an eligibility predicate chain: `isDerivative.and(isInScope).and(notExpired)`
- **Exgester tie-in:** decision steps ARE functions; pipelines compose them

### Session 4 — Streams Mastery
- map/filter/flatMap/reduce; `Collectors.groupingBy`, `partitioningBy`, `toMap`; laziness & terminal ops
- **Build:** batch-process a `List<TradeEvent>` — group by asset class, partition by eligibility, summarize per regime
- **Exgester tie-in:** enrichment and batch flows lean on streams heavily

### Session 5 — Optional Done Right
- `map`/`flatMap`/`filter`/`orElseGet`/`orElseThrow`; anti-patterns (`isPresent()+get()`, Optional fields/params)
- Optional as the gateway drug to Vavr `Option`
- **Build:** refactor a null-riddled trade-lookup service into Optional chains
- **Exgester tie-in:** the "maybe missing" discipline that Vavr generalizes

### Session 6 — SOLID + Week 1 Review
- SOLID through an event-driven lens: SRP = one decision per step; OCP = new regimes without touching old code; DIP = pipelines depend on interfaces
- **Grill:** 15-question retrieval quiz across Sessions 1–5; write the week's learning record

---

## Week 2 — Functional Programming & Vavr: the Heart of Exgester

*Why: the user-stated MOST IMPORTANT skill. Railway-oriented programming with `Either<L,R>` is how every Exgester decision pipeline is written.*

### Session 7 — The FP Mindset
- Pure functions, referential transparency, side-effect isolation (push effects to the edges: JMS in, JMS out, logs)
- Higher-order functions; why exceptions break composition and what replaces them
- **Build:** refactor an exception-throwing validator into one that *returns* its failure
- **Primary source:** Scott Wlaschin's Railway-Oriented Programming talk (see [RESOURCES.md](./RESOURCES.md))

### Session 8 — Vavr Foundations: Option, Try, Tuple
- `Option` vs `Optional` (serializable, richer API); `Try.of(...)` wrapping dangerous calls; `Tuple2/Tuple3` for multi-returns
- Vavr collections quick tour (`io.vavr.collection.List` — immutable, persistent)
- **Build:** wrap Jackson parsing in `Try`, convert to `Either` with `.toEither(reason)`

### Session 9 — Either Fundamentals
- Left = failure track, Right = success track (and why that convention); right-bias
- Creating: `Either.right(...)`, `Either.left(...)`, conditional `Either.cond(...)`
- Extracting: `fold`, `getOrElse`, `swap`, `peek`/`peekLeft`
- **Build:** rewrite Session 2's homemade `Result` code with real `Either` — feel the API superiority

### Session 10 — Railway-Oriented Programming
- `map` (transform success) vs `flatMap` (chain another Either-returning step) — THE core distinction
- Building a pipeline: `parse(...).flatMap(this::checkEligibility).flatMap(this::determineRegime).map(this::enrich)`
- Short-circuiting: the first Left rides the failure track past all remaining steps
- **Build:** Mini-Exgester decision engine v1 — 4-step Either pipeline with typed `RejectionReason`

### Session 11 — Advanced Railways
- Error recovery: `orElse`, `recover` patterns; `peek` for logging without derailing
- Accumulating vs short-circuiting errors: `Validation<Seq<E>, T>` for field-level validation
- Combining independent Eithers; `Either.sequence(...)`
- **Build:** add a `Validation`-based field validator that reports ALL invalid fields, then folds into the pipeline

### Session 12 — Build Week: Decision Engine v2 + Review
- **Build (full session):** extend the engine — regime determination returning `Set<Regime>`, rejection audit trail via `peekLeft`, `fold` at the edge to route to submission vs rejection queue
- **Grill:** ROP retrieval quiz; learning record

---

## Week 3 — Design Patterns: the Structure of Exgester

*Why: multi-client, multi-regime engines survive by patterns. You'll recognize these instantly in the real codebase.*

### Session 13 — Strategy
- Interface + N implementations; Spring-injected `Map<String, ReportingStrategy>` / `List<T>` autowiring
- **Build:** `RegimeReportingStrategy` — EMIR, ASIC, CFTC implementations selected at runtime per trade

### Session 14 — Factory & Builder
- Factory method vs abstract factory; Spring `@Bean` methods ARE factories; Lombok `@Builder` mechanics (and `toBuilder`)
- **Build:** `SubmissionMessageFactory` producing per-regime submission messages via builders

### Session 15 — Template Method
- Abstract base flow with protected hooks; when Spring + composition beats inheritance
- **Build:** `AbstractSubmissionFlow` — common skeleton (validate → transform → send), client-specific overrides

### Session 16 — Chain of Responsibility
- Handler chains; ordering (`@Order`, `List<Handler>` injection); chain vs Either-railway (they compose!)
- **Build:** eligibility rule chain where each handler can pass, reject, or delegate

### Session 17 — Composite
- Tree-structured rules: `AndRule(OrRule(a, b), c)`; recursive evaluation
- **Build:** composite validation rules configured per regime

### Session 18 — Pattern Synthesis + Review
- Pattern-spotting drill: given anonymized pipeline shapes, name the pattern and justify
- How the patterns nest in Mini-Exgester: Chain inside Railway, Strategy chosen by Factory, Composite rules inside a Strategy
- **Grill:** patterns quiz; learning record

---

## Week 4 — Multi-Tenant Spring Boot, Config & Messaging: the Skeleton of Exgester

*Why: one deployable serving ANZ/WBC/Santander/Wells Fargo via profiles + YAML is Exgester's defining architecture.*

### Session 19 — DI Deep Dive
- Constructor injection (why field injection is banned), `@Configuration` + `@Bean`, bean lifecycle, qualifiers, conditional beans
- **Build:** wire the decision engine entirely via constructor injection with explicit `@Configuration` classes

### Session 20 — @Profile & Multi-Tenancy
- `@Profile` mechanics, profile expressions (`!`, `&`, `|`), profile groups
- **Custom composed profile annotations** — build `@AnzProfile`, `@WbcProfile` (meta-annotated with `@Profile("anz")`) exactly like Exgester's client annotations
- **Build:** client-specific flow beans; boot the same jar as ANZ then WBC and watch behavior switch

### Session 21 — YAML Configuration Mastery
- `@ConfigurationProperties` (typed, validated, constructor-bound) vs `@Value`; multi-document YAML; `application-<client>.yml` layering; property precedence
- **Build:** per-client config: enabled regimes, queue names, feature flags — bound to immutable config classes

### Session 22 — Jackson Deep Dive
- `ObjectMapper` configuration as a bean; `@JsonProperty`, `@JsonIgnore`, `@JsonInclude`; deserializing into immutable/Lombok classes (`@Jacksonized`); polymorphic messages (`@JsonTypeInfo`); unknown-field tolerance
- **Build:** version-tolerant `TradeEvent` deserialization + custom serializer for regulatory timestamp formats

### Session 23 — JMS in the Exgester Context
- Review through new eyes: `@JmsListener` concurrency, `MessageConverter` vs manual mapping, error handling → DLQ, idempotency/redelivery
- Side-effect isolation applied: listener = thin edge, pipeline = pure core, sender = thin edge
- **Build:** wire Mini-Exgester to real AMQ (Docker) — trade in, submission out, rejection queue for Lefts

### Session 24 — Build Week: Multi-Tenant Mini-Exgester + Review
- **Build (full session):** run TWO client profiles with different regimes/queues from one codebase; demonstrate a client-specific decision step activating only for ANZ
- **Grill:** profiles/config/Jackson quiz; learning record

---

## Week 5 — Testing, Quality & Capstone: Proving Mastery

*Why: at S&P Global you ship changes with tests, coverage, and style gates. This week makes you production-safe.*

### Session 25 — JUnit 5 + AssertJ + Mockito
- Parameterized tests, nested tests; AssertJ fluent assertions; Vavr assertions (`assertThat(either.isRight())`, or `VavrAssertions`); mocking edges only — never the pipeline
- **Build:** full unit suite for the decision engine — every step, both tracks

### Session 26 — Cucumber & BDD
- Gherkin: Feature/Scenario/Given-When-Then, Scenario Outlines + Examples tables; step definitions; `cucumber-spring` glue
- **Build:** `trade_reporting.feature` — "Given an ANZ equity derivative trade, When processed, Then an EMIR submission is produced"
- **Exgester tie-in:** this mirrors how Exgester's behavior is specified per client/regime

### Session 27 — Maven, JaCoCo & Checkstyle
- Maven lifecycle (validate→compile→test→package→verify), dependency scopes, profiles-in-Maven vs Spring profiles
- JaCoCo: coverage report, thresholds failing the build; Checkstyle: reading violations, common enterprise rulesets
- **Build:** add all three gates to Mini-Exgester; drive coverage above the bar; fix style violations

### Session 28 — Docker for the Dev Loop
- Images vs containers; `docker compose up` for AMQ + app; Dockerfile for a Spring Boot jar; env vars → Spring profiles inside containers
- **Build:** `docker compose` running broker + Mini-Exgester-as-ANZ + Mini-Exgester-as-WBC side by side

### Session 29 — Capstone Assembly
- **Build (full session):** end-to-end run — send 10 varied trade events, watch railway routing, submissions per regime, rejections with reasons; Cucumber suite green; JaCoCo/Checkstyle passing

### Session 30 — Final Grill & Exgester Readiness Review
- 30-question comprehensive grill across all five weeks
- Map every Mini-Exgester component to its real-Exgester counterpart; write the final learning record
- Define your first real-codebase task plan: how you'll approach your first Exgester ticket

---

## Skill Coverage Map

| Skill (from mission) | Sessions |
|---|---|
| OOP & SOLID | 1, 6, 13–18 |
| Generics | 2, 9 |
| Collections & Streams | 4, 8 |
| Lambdas & Functional Interfaces | 3, 7 |
| Optional | 5, 8 |
| Immutability | 1, 21, 22 |
| Functional composition & HOFs | 3, 7, 10 |
| **Railway-Oriented Programming / Vavr Either** | **9–12, 23, 25, 29** |
| Side-effect isolation | 7, 23 |
| Vavr Option / Try / Tuple / Validation | 8, 11 |
| DI & constructor injection | 19 |
| @Configuration / @Bean / Profiles / YAML | 19–21, 24 |
| Spring JMS / AMQ / JmsListener / JmsTemplate | 23, 24, 28 (foundations: parent AMQ course) |
| Strategy / Factory / Template / Chain / Composite / Builder | 13–18 |
| Jackson | 22 |
| Lombok | 1, 14, 22 |
| Cucumber / BDD / JUnit | 25, 26, 29 |
| Maven / JaCoCo / Checkstyle / Docker | 27, 28 |

## Rules of the Road
1. **Never skip the warm-up retrieval.** Storage strength beats fluency.
2. **Type every example yourself.** No copy-paste of pipeline code.
3. **One session per day maximum.** Spacing is the point.
4. **If a session overruns, stop at 2 h** and resume next day — do not compress the next session.
5. **After Sessions 6, 12, 18, 24, 30:** the agent writes a learning record capturing what stuck.
