# Teaching Notes

## User Preferences
- Learns best through building projects (project-based approach)
- Already proficient with Spring Boot REST APIs and databases — skip the basics
- Targeting S&P Global Market Intelligence (MarkIT India) — enterprise financial services context
- Wants both Spring Profiles and ActiveMQ covered in 1 week
- Available 2-3 hours/day
- **Wants infrastructure context** — don't just explain code abstractions, explain WHERE things run physically (servers, ports, TCP, Docker vs VM), HOW services communicate on the network, and WHY the architecture is structured this way. Ground every concept in the physical reality.
- Prefers "what is a broker", "where is it deployed", "how do services find each other" — always anchor abstract concepts to a real deployment diagram before diving into code.

## Technical Context
- S&P Global MI job listings emphasize: Spring Boot, microservices, messaging (Kafka/ActiveMQ mentioned), AWS, Docker
- Enterprise financial services typically use both ActiveMQ Classic (legacy) and Artemis (modern)
- Teaching Artemis as primary (Spring Boot 3 native support) with Classic awareness for interviews
- User chose "whichever enterprises use" — covering both, leaning Artemis

## Teaching Approach Decisions
- **Infrastructure-first, code-second**: Every new concept starts with a diagram of where things live physically, then moves to the Spring Boot code.
- **Interview callouts**: Mark key interview insights with a "Interview Insight" callout box — the user is preparing for S&P Global MI.
- **REST vs Messaging comparisons**: User already knows REST well, so use REST as the anchor point to explain messaging concepts (phone call vs postal mail analogy).
- **Three progressive projects**: Notification Hub → Order Processing → Financial Pipeline. Each builds on the last.
- **Embedded quizzes**: Every lesson has interactive quizzes for retrieval practice.

## Workspace Inventory
| File | Purpose | Status |
|------|---------|--------|
| `MISSION.md` | Learning goal & success criteria | ✅ Created |
| `RESOURCES.md` | Curated high-trust resources | ✅ Created |
| `NOTES.md` | This file — teaching preferences & log | ✅ Active |
| `assets/style.css` | Shared stylesheet (all lessons) | ✅ Created |
| `assets/quiz.js` | Interactive quiz widget | ✅ Created |
| `lessons/0001-your-seven-day-roadmap.html` | Lesson 01: Roadmap + Infrastructure Foundations | ✅ Created + Updated |
| `reference/glossary.html` | Term definitions | ✅ Created |
| `reference/cheatsheet.html` | Syntax quick reference | ✅ Created |
| `learning-records/0001-spring-boot-rest-proficiency.md` | Prior knowledge baseline | ✅ Created |

## Lesson Plan (14 lessons across 7 days)
| # | Title | Day | Status |
|---|-------|-----|--------|
| 01 | Your 7-Day Roadmap + Infrastructure Foundations | 1 | ✅ Done |
| 02 | JMS Mental Model & ActiveMQ Setup | 1 | ✅ Done |
| 03 | Your First Queue: Send & Receive | 1 | ✅ Done |
| 04 | Spring Profiles: Environment Configuration | 2 | 🔲 Next |
| 05 | JSON Messages & MessageConverter | 2 | 🔲 Planned |
| 06 | Topics & Pub/Sub Patterns | 3 | 🔲 Planned |
| 07 | Building the Order Processing System | 3 | 🔲 Planned |
| 08 | Dead Letter Queues & Error Handling | 4 | 🔲 Planned |
| 09 | Advanced Profiles: @Profile Beans & Groups | 4 | 🔲 Planned |
| 10 | Request-Reply & Message Selectors | 5 | 🔲 Planned |
| 11 | Financial Data Pipeline Project | 6 | 🔲 Planned |
| 12 | Transactions & Durable Subscribers | 6 | 🔲 Planned |
| 13 | Integration Testing with Embedded Broker | 7 | 🔲 Planned |
| 14 | Interview Prep: Classic vs Artemis & Architecture | 7 | 🔲 Planned |

## Session Log
- **Session 1** (2026-07-27):
  - Mission established — S&P Global MI interview prep
  - Created full workspace: assets, references, glossary, cheatsheet
  - Built Lesson 01 with roadmap, 3-project plan, concepts map
  - User requested infrastructure grounding → added Infrastructure Foundations section to Lesson 01 (services, brokers, deployment, ports, TCP, REST vs Messaging comparison)
  - Recorded infrastructure-first teaching preference
  - Next: Lesson 02 (JMS Mental Model & ActiveMQ Setup)
