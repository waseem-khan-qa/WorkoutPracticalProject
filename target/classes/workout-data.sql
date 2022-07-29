INSERT INTO `exercise` (`id`, `calories`, `equipment_desc`, `exercise_desc`, `title`) VALUES
(1, 10, 'No Equipment', 'Exercise 1', 'E1'),
(2, 20, 'Equipment 1', 'Exercise 2', 'E2'),
(3, 10, 'No Equipment', 'Exercise 3', 'E3'),
(4, 20, 'Equipment 1', 'Exercise 4', 'E4');

INSERT INTO `workout` (`id`, `date`, `location`, `start_time`, `time_duration`, `title`) VALUES
(1, '2022-01-20', 'Any', '11:15:00', 10, 'W1'),
(2, '2022-02-23', 'Outdoor', '07:15:00', 15, 'W2');

INSERT INTO `workout_exercises` (`workout_id`, `exercises_id`) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4);
