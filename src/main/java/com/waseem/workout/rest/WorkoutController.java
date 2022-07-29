package com.waseem.workout.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.waseem.workout.entity.Workout;
import com.waseem.workout.service.WorkoutService;

@RestController
public class WorkoutController {
	@Autowired
	private WorkoutService workoutService;
	
	@GetMapping("/")
	public ModelAndView home() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("workouts", workoutService.getAll());
	    modelAndView.setViewName("index");
	    return modelAndView;
	}

	@GetMapping("/addWorkout")
	public ModelAndView addWorkout() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("workout", new Workout());
	    modelAndView.setViewName("addWorkout");
		return modelAndView;
	}

	@PostMapping("/addWorkout")
	public ModelAndView addToWorkOut(@ModelAttribute Workout workout) {		
		workoutService.create(workout);
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("workouts", workoutService.getAll());
	    modelAndView.setViewName("index");
		return modelAndView;
	}

	@GetMapping("/editWorkout/{id}")
	public ModelAndView showWorkoutForm(@PathVariable("id") int id) {
		Workout w = workoutService.getById(id);
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("workout", w);
	    modelAndView.setViewName("updateWorkout");
	    return modelAndView;
	}
	@PostMapping("/updateWorkout/{id}")
	public ModelAndView updateWorkout(@PathVariable("id") int id, @ModelAttribute Workout w) {	 
		workoutService.update(id, w.getTitle(), w.getTimeDuration(), w.getLocation(), w.getStartTime(), w.getDate(), w.getExercises());
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("workouts", workoutService.getAll());
	    modelAndView.setViewName("index");
	    return modelAndView;
	}	
	@GetMapping("/deleteWorkout/{id}")
	public ModelAndView deleteWorkout(@PathVariable("id") int id) {
		workoutService.delete(id);
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("workouts", workoutService.getAll());
	    modelAndView.setViewName("index");
	    return modelAndView;
	}	

}
