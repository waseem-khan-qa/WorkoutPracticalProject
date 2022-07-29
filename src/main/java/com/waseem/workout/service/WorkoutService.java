package com.waseem.workout.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.waseem.workout.entity.Exercise;
import com.waseem.workout.entity.Workout;

public interface WorkoutService {
	Workout getById(int id);

	List<Workout> getAll();

	Workout findByName(String name);

	Workout create(Workout workout);

	Workout update(int id, String name, int timeDuration, String location, LocalTime time, LocalDate date, List<Exercise> exercises);

	void delete(int id);

}
