package com.waseem.workout.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.waseem.workout.entity.Exercise;
import com.waseem.workout.entity.Workout;
import com.waseem.workout.service.ExerciseService;
import com.waseem.workout.service.WorkoutService;


@RestController
public class ExerciseController {
	@Autowired
	private ExerciseService exerciseService;
	@Autowired
	private WorkoutService workoutService;
	
	@GetMapping("/addExercise")
	public ModelAndView addExercise() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exercise", new Exercise());
	    modelAndView.addObject("workouts", workoutService.getAll());
	    modelAndView.setViewName("addExercise");
	    return modelAndView;
	}

	@PostMapping("/addExercise")
	public ModelAndView addToExercise(@ModelAttribute Exercise exercise, @RequestParam int workoutId) {
		Exercise e = exerciseService.create(exercise);
		System.out.println("ID: " + workoutId);
		Workout w = workoutService.getById(workoutId);
		w.getExercises().add(e);
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("workouts", workoutService.getAll());
	    modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@GetMapping("/editExercise/{id}")
	public ModelAndView showUpdateForm(@PathVariable("id") int id) {
		Exercise exercise = exerciseService.getById(id);
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exercise", exercise);
	    modelAndView.setViewName("updateExercise");
	    return modelAndView;
	}
	@PostMapping("/updateExercise/{id}")
	public ModelAndView updateExercise(@PathVariable("id") int id, @ModelAttribute Exercise exercise) {	 
		exercise.setId(id);
		exerciseService.update(exercise.getId(), exercise.getTitle(), exercise.getExerciseDesc(), exercise.getCalories(), exercise.getEquipmentDesc());
		for(Workout workout : workoutService.getAll()) {
			for(Exercise e : workout.getExercises()) {
				if(e.getId() == id) {
					e = exercise;
				}
			}
		}
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("workouts", workoutService.getAll());
	    modelAndView.setViewName("index");
	    return modelAndView;
	}	
	@GetMapping("/deleteExercise/{id}")
	public ModelAndView deleteExercise(@PathVariable("id") int id) {
		for(Workout w: workoutService.getAll()) {
			for(Exercise e : w.getExercises()) {
				if(e.getId() == id) {
					w.getExercises().remove(e);
				}
			}
		}
		exerciseService.delete(id);
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("workouts", workoutService.getAll());
	    modelAndView.setViewName("index");
	    return modelAndView;
	}

	@GetMapping("/showExercise/{id}")
	public ModelAndView showExercise(@PathVariable("id") int id) {
		Workout w = workoutService.getById(id);
		ModelAndView model = new ModelAndView();
		model.addObject("exercises", w.getExercises());	
		model.setViewName("showExercise");
		return model;
	}
	
}
