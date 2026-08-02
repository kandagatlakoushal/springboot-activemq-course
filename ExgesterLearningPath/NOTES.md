# Teaching Notes — Exgester Learning Path

## User Preferences (carried over from parent AMQ workspace + new)
- **Project-based learner** — every session needs a build task; theory alone doesn't stick
- **Infrastructure-first** — anchor abstractions to where things physically run before showing code
- Already proficient: Spring Boot REST, databases, JMS/AMQ fundamentals (parent course Lessons 1–7)
- Works at S&P Global MI, Cappitech project, on the **Exgester** module (previous mission — getting the job — succeeded)
- 1–2 h/day budget; 5-week plan agreed
- Every concept must answer: "where does this show up in Exgester?"
- **Never accept proprietary Exgester code** — teach via Mini-Exgester reconstruction only

## Technical Context (user-described Exgester architecture)
- Spring Boot event-driven trade reporting engine: AMQ/JMS in → decision engine → regulatory submission out
- Decision pipelines: **Vavr `Either<L,R>` railway-oriented programming** (user flags as MOST IMPORTANT)
- Multi-tenant: ANZ, WBC (Westpac), Santander, Wells Fargo via **custom composed @Profile annotations** + per-client YAML
- Regimes: EMIR, FCA (UK EMIR), ASIC, CFTC, etc.
- Stack: Vavr (Either/Option/Try/Tuple), Jackson, Lombok, Cucumber/JUnit, Maven/JaCoCo/Checkstyle, Docker
- Patterns in play: Strategy, Factory, Template Method, Chain of Responsibility, Composite, Builder
- TODO: ask user for the team's exact Vavr version and pin lessons to it

## Teaching Approach Decisions
- **Sequence:** Java fluency → Vavr/ROP → patterns → multi-tenant Spring/messaging → testing/quality. Rationale: Either is unreadable without generics/lambdas; patterns are hollow without FP context; profiles/config come once there's an engine to make multi-tenant.
- **Capstone thread:** Mini-Exgester grows session by session (from Session 10); final weeks make it multi-tenant, tested, gated, dockerized.
- **Retrieval discipline:** warm-up quiz every session; cumulative grills at Sessions 6/12/18/24/30; learning records only on evidence.
- Reuse parent workspace assets: lessons link `../../assets/style.css` and `../../assets/quiz.js`.
- Lesson numbering restarts at 0001 within `ExgesterLearningPath/lessons/`.

## Workspace Inventory
| File | Purpose | Status |
|---|---|---|
| MISSION.md | Goal & success criteria | ✅ Created |
| CURRICULUM.md | 5-week / 30-session syllabus | ✅ Created |
| INSTRUCTION-MANUAL.md | How to run the path | ✅ Created |
| PROMPT-LIBRARY.md | Session-driving prompts | ✅ Created |
| RESOURCES.md | High-trust sources | ✅ Created |
| ExgesterModule.md | Index / front door | ✅ Created |
| lessons/0001-….html | Session 1 lesson | ✅ Created |
| reference/ | Cheatsheets & glossary | 🔲 Grows with lessons |
| learning-records/0001 | Baseline prior knowledge | ✅ Created |
| mini-exgester/ | Capstone project | 🔲 Starts Session 10 (scaffold earlier if user wants) |

## Progress Tracker
| Week | Sessions | Status |
|---|---|---|
| 1 — Modern Java | 1–6 | 🔲 Session 1 lesson ready |
| 2 — FP & Vavr | 7–12 | 🔲 |
| 3 — Design Patterns | 13–18 | 🔲 |
| 4 — Multi-Tenant Spring | 19–24 | 🔲 |
| 5 — Testing & Capstone | 25–30 | 🔲 |

## Session Log
- **Setup session** (2026-08-02):
  - User now employed at S&P Global MI (Cappitech) — parent workspace mission accomplished
  - New mission established: master Exgester-maintenance skills in 5 weeks
  - Full workspace scaffolded: mission, curriculum, manual, prompt library, resources, baseline learning record
  - Lesson 0001 (orientation: Exgester mental model + roadmap) authored
  - Next: user runs Session 1 via PROMPT-LIBRARY prompt #1
