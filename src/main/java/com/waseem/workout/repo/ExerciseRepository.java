package com.waseem.workout.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waseem.workout.entity.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer>{
	Exercise findByTitleStartingWithIgnoreCase(String title);

}
