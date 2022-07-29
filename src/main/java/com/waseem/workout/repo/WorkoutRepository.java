package com.waseem.workout.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waseem.workout.entity.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer>{
	Workout findByTitleStartingWithIgnoreCase(String title);
}
