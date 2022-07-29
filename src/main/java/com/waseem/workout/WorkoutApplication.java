package com.waseem.workout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.waseem.workout.rest.ExerciseController;
import com.waseem.workout.rest.WorkoutController;

@SpringBootApplication
public class WorkoutApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WorkoutApplication.class, args);
		System.out.println("Found the bean: " + context.getBean(ExerciseController.class));
		System.out.println("Found the bean: " + context.getBean(WorkoutController.class));
	}

}
