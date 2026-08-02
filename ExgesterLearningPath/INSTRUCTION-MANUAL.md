# Instruction Manual — How to Run the Exgester Learning Path

This folder is a self-contained **teaching workspace** driven by the `/teach` skill. This manual explains how the system works and exactly what to do each day.

## The Folder

| Artifact | What it is | When it changes |
|---|---|---|
| [MISSION.md](./MISSION.md) | Why you're learning this; success criteria | Only when your goal shifts |
| [CURRICULUM.md](./CURRICULUM.md) | The 5-week, 30-session syllabus | Rarely — it's the map |
| [PROMPT-LIBRARY.md](./PROMPT-LIBRARY.md) | Copy-paste prompts to drive each session | Grows as useful prompts emerge |
| [RESOURCES.md](./RESOURCES.md) | High-trust sources lessons draw from | Grows; pruned ruthlessly |
| [NOTES.md](./NOTES.md) | Teaching preferences + session log | Every session |
| lessons/ | One beautiful HTML lesson per session, `0001-….html` | One added per session |
| reference/ | Cheatsheets & glossary — the compressed essence | Updated as lessons land |
| learning-records/ | Evidence of what you actually mastered | After review sessions |
| mini-exgester/ | The capstone codebase you build from Week 2 | Most sessions |

**Lessons are NOT pre-written.** The agent authors each lesson when you ask for it, calibrated to your
zone of proximal development using your learning records. The curriculum is the map; lessons are the territory.

## The Daily Ritual (1–2 hours)

```
① WARM-UP (10 min)   Ask the agent to quiz you on the previous session — from memory, no peeking.
② LESSON  (20–30 min) Ask the agent for today's lesson (see PROMPT-LIBRARY). Read it fully. Take the embedded quizzes.
③ BUILD   (45–60 min) Do the session's build task in mini-exgester/. Type everything yourself.
④ GRILL   (10 min)   Ask the agent to grill you on today's material. Be honest about misses.
```

Use the session prompts in [PROMPT-LIBRARY.md](./PROMPT-LIBRARY.md) verbatim — they encode this ritual.

## Rules the Agent Follows (so you can hold it to them)

1. **One lesson per session**, saved to `lessons/` with incrementing numbers, linking the shared stylesheet at `../../assets/style.css` and quiz widget at `../../assets/quiz.js`.
2. **Every lesson cites primary sources** from [RESOURCES.md](./RESOURCES.md) — never parametric guesses.
3. **Every lesson ends with retrieval practice** (quizzes with same-length answers, no formatting clues).
4. **Reference documents get updated** when a lesson introduces durable knowledge (glossary terms, Vavr API patterns, pattern cheatsheets).
5. **Learning records are written on evidence only** — after you demonstrate understanding in a grill, not after mere exposure.
6. **The agent updates [NOTES.md](./NOTES.md)** session log every session, so any future conversation can resume exactly where you left off.
7. **Lessons connect to Exgester** — every concept must answer "where does this show up in a trade reporting engine?"

## Progress Tracking

The session log in [NOTES.md](./NOTES.md) is the single source of truth for where you are.
If you ever start a fresh conversation, just say:

> Read ExgesterLearningPath/NOTES.md and ExgesterLearningPath/CURRICULUM.md, then continue my Exgester learning path where I left off.

## Missed Days & Pacing

- **Missed 1–2 days:** just continue; do NOT double up sessions.
- **Missed a week+:** ask for a "re-entry review" (prompt in the library) — the agent re-quizzes the last two sessions before continuing.
- **A session felt too easy/hard:** say so. The agent recalibrates your zone of proximal development and notes it in NOTES.md.

## The Capstone Convention

From Session 10 onward, most build tasks land in `mini-exgester/` — a real Maven + Spring Boot project.
It intentionally mirrors Exgester's shape:

| Mini-Exgester | Real Exgester counterpart |
|---|---|
| `TradeEvent` immutable model | Inbound trade event payloads |
| `Either<RejectionReason, …>` pipeline | Decision pipelines |
| `@AnzProfile` / `@WbcProfile` composed annotations | Client profile annotations |
| `application-<client>.yml` | Client YAML configs |
| Strategy per regime + SubmissionFactory | Regime handling & submission creation |
| Cucumber features per client/regime | BDD specs |

**Never paste proprietary Exgester code into this workspace or into the agent.** Describe shapes and
patterns in your own words instead; the agent reconstructs equivalent open examples.

## Weekly Checkpoints

After Sessions 6, 12, 18, 24, 30 the agent must:
1. Run a cumulative grill (not just the current week)
2. Write a learning record with evidence
3. Update the reference docs
4. Confirm or adjust next week's plan against your zone of proximal development
