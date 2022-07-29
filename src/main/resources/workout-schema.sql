DROP TABLE IF EXISTS `exercise`;
CREATE TABLE `exercise` (
  `id` int(11) NOT NULL,
  `calories` int(11) NOT NULL,
  `equipment_desc` varchar(255) DEFAULT NULL,
  `exercise_desc` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `workout`;
CREATE TABLE `workout` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `time_duration` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `workout_exercises`;
CREATE TABLE `workout_exercises` (
  `workout_id` int(11) NOT NULL,
  `exercises_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `exercise`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `workout`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `workout_exercises`
  ADD KEY `exercise_id_fk` (`exercises_id`),
  ADD KEY `workout_id_fk` (`workout_id`);

ALTER TABLE `exercise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `workout`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

COMMIT;
