package com.waseem.workout.service;

import java.util.List;

import com.waseem.workout.entity.Exercise;


public interface ExerciseService {

	Exercise getById(int id);

	List<Exercise> getAll();

	Exercise findByName(String name);

	Exercise create(Exercise exercise);

	Exercise update(int id, String name, String desc, int cal, String equip);

	void delete(int id);

}
