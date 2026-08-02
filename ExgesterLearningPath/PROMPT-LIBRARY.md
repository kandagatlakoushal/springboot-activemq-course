# Prompt Library — Exgester Learning Path

Copy-paste these prompts to drive each part of the daily ritual. Replace `<N>` with the session number
from [CURRICULUM.md](./CURRICULUM.md). All prompts assume the agent will first read
`ExgesterLearningPath/NOTES.md`, `MISSION.md`, and `CURRICULUM.md` for context.

---

## Core Daily Prompts

### 1. Start a session (the workhorse prompt)
```
/teach Continue my Exgester learning path. Read ExgesterLearningPath/NOTES.md,
MISSION.md and CURRICULUM.md. Today is Session <N>. First give me a 5-question
warm-up quiz on the previous session (wait for my answers), then author the
Session <N> lesson as lessons/<NNNN>-<slug>.html following the curriculum,
reusing ../../assets/style.css and ../../assets/quiz.js. End by giving me
today's build task for mini-exgester/ and update the session log in NOTES.md.
```

### 2. Warm-up only
```
Quiz me from memory on Session <N-1> of my Exgester learning path — 5 questions,
one at a time, wait for each answer, then give corrective feedback. No peeking
at the lesson. Base it on ExgesterLearningPath/lessons/ and learning-records/.
```

### 3. Get help mid-build
```
I'm on Session <N>'s build task in ExgesterLearningPath/mini-exgester/. I'm stuck:
<describe the problem / paste the error>. Don't write the solution for me —
give me a hint ladder: first a nudge, then a stronger hint if I ask, and only
show code as a last resort.
```

### 4. End-of-session grill
```
Grill me on today's Session <N> material. 8 questions, increasing difficulty,
one at a time. Include at least one "explain it like I'm reviewing a PR" question
and one code-reading question. At the end, tell me honestly which concepts are
not yet at storage strength, and log the session in ExgesterLearningPath/NOTES.md.
```

---

## Review & Checkpoint Prompts

### 5. Weekly checkpoint (Sessions 6, 12, 18, 24, 30)
```
Run my weekly Exgester checkpoint. Cumulative grill covering all sessions so far
(15 questions, weighted toward this week). Then: write a learning record in
ExgesterLearningPath/learning-records/ based on evidence from my answers, update
reference/ docs with anything durable, and confirm next week's plan still fits
my zone of proximal development.
```

### 6. Re-entry after a break
```
I've been away from my Exgester learning path for a while. Read
ExgesterLearningPath/NOTES.md, quiz me on the last two completed sessions, and
based on my answers decide whether to continue to the next session or re-teach.
Update NOTES.md with your decision.
```

### 7. Recalibrate difficulty
```
Session <N> felt <too easy | too hard> because <reason>. Recalibrate: adjust how
you pitch future lessons, note the preference in ExgesterLearningPath/NOTES.md,
and tell me what changes.
```

---

## Deep-Dive Prompts (use anytime)

### 8. Explain a Vavr/railway concept against MY code
```
Look at <file/class> in ExgesterLearningPath/mini-exgester/. Walk me through it
on a whiteboard level: draw the two railway tracks, show exactly where a Left
short-circuits, and what fold() does at the edge. Then ask me to predict the
output for 3 different inputs before you reveal them.
```

### 9. Pattern-spotting drill
```
Give me a pattern-spotting drill: show me 4 short anonymized Java snippets shaped
like real trade-reporting engine code (Strategy, Factory, Chain of Responsibility,
Template Method, Composite — your pick). I name the pattern and justify it;
you correct me. Track my score.
```

### 10. Signature-reading drill (generics fluency)
```
Drill me on reading generic method signatures from Vavr's Either, Option, Try and
Validation. Show one real signature at a time from the Vavr javadoc, I explain in
plain English what it does, you correct me. 6 rounds, increasing difficulty.
```

### 11. "Explain the flow" interview drill
```
Act as a senior Exgester engineer interviewing me. Ask me to explain the complete
journey of a trade event: AMQ → listener → deserialization → Either pipeline →
regime strategies → submission factory → outbound queue. Probe my answer with
3 follow-up questions like a real design review.
```

### 12. Refactor-to-railway kata
```
Give me a kata: a 30-line imperative Java method full of null checks, try/catch
and early returns (trade-validation themed). My job: refactor it to a Vavr
Either railway. Review my attempt like a strict PR reviewer — comment severity:
must-fix / should-fix / nit.
```

### 13. Cucumber scenario kata
```
Give me a plain-English trade reporting requirement (e.g. "ANZ interest-rate swaps
must be reported to both EMIR and ASIC unless notional is below X"). I write the
Gherkin feature file; you review it, then I write step definitions; you review
those against cucumber-spring best practice.
```

### 14. YAML/profile debugging drill
```
Set up a profile-debugging drill: show me a multi-tenant Spring Boot config
(application.yml + application-anz.yml + a custom @AnzProfile annotation) with
one subtle misconfiguration. I have to find why the wrong bean loads. Escalate
through 3 rounds, harder each time.
```

---

## Maintenance Prompts

### 15. Update the glossary
```
Review today's lesson and our conversation. Which terms did I demonstrably use
correctly? Promote only those into ExgesterLearningPath/reference/glossary.html
following the glossary format. Show me what you added.
```

### 16. Add a resource
```
I found this resource: <link>. Evaluate it against the RESOURCES.md trust rules
(primary source? recognized expert? marketing?). If it passes, add it with a
one-line annotation to ExgesterLearningPath/RESOURCES.md; if not, tell me why.
```

### 17. Mission drift check
```
Read ExgesterLearningPath/MISSION.md and the learning records. Based on what
I've learned and what I'm telling you now: <new situation>. Does the mission
need revising? Propose the edit before making it.
```
