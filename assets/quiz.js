/**
 * Quiz Widget — Reusable quiz component for lessons
 * 
 * Usage:
 *   <div class="quiz" data-quiz="unique-id">
 *     <p class="quiz-question">Question text?</p>
 *     <ul class="quiz-options">
 *       <li data-correct>Correct answer</li>
 *       <li>Wrong answer A</li>
 *       <li>Wrong answer B</li>
 *       <li>Wrong answer C</li>
 *     </ul>
 *     <div class="quiz-feedback"></div>
 *   </div>
 *
 * The widget handles selection, validation, feedback, and prevents re-answering.
 */
(function () {
  'use strict';

  document.addEventListener('DOMContentLoaded', function () {
    const quizzes = document.querySelectorAll('.quiz[data-quiz]');

    quizzes.forEach(function (quiz) {
      const options = quiz.querySelectorAll('.quiz-options li');
      const feedback = quiz.querySelector('.quiz-feedback');
      let answered = false;

      // Shuffle options so correct answer isn't always first
      const optionsList = quiz.querySelector('.quiz-options');
      const items = Array.from(options);
      for (let i = items.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        optionsList.appendChild(items[j]);
      }

      options.forEach(function (option) {
        option.addEventListener('click', function () {
          if (answered) return;
          answered = true;

          const isCorrect = option.hasAttribute('data-correct');

          // Mark all options
          options.forEach(function (opt) {
            opt.style.pointerEvents = 'none';
            if (opt.hasAttribute('data-correct')) {
              opt.classList.add('correct');
            }
          });

          if (!isCorrect) {
            option.classList.add('incorrect');
          }

          // Show feedback
          feedback.classList.add('show');
          if (isCorrect) {
            feedback.classList.add('correct');
            feedback.textContent = '✓ Correct! ' + (option.getAttribute('data-explanation') || '');
          } else {
            feedback.classList.add('incorrect');
            const correctOption = quiz.querySelector('[data-correct]');
            feedback.textContent = '✗ Not quite. The answer is: ' + correctOption.textContent +
              (correctOption.getAttribute('data-explanation') ? ' — ' + correctOption.getAttribute('data-explanation') : '');
          }
        });
      });
    });
  });
})();
