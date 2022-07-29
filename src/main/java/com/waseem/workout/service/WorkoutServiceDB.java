package com.waseem.workout.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.waseem.workout.entity.Exercise;
import com.waseem.workout.entity.Workout;
import com.waseem.workout.repo.WorkoutRepository;

@Service
@Primary
public class WorkoutServiceDB implements WorkoutService {

	@Autowired
	private WorkoutRepository repo;

	public WorkoutServiceDB(WorkoutRepository repo)
    {
        this.repo = repo;
    }
	@Override
	public Workout getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Workout> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Workout findByName(String name) {
		return this.repo.findByTitleStartingWithIgnoreCase(name);
	}

	@Override
	public Workout create(Workout workout) {
		return this.repo.save(workout);
	}

	@Override
	public Workout update(int id, String name, int timeDuration, String location, LocalTime time, LocalDate date, List<Exercise> exercises) {
		Workout toUpdate = this.getById(id);
		if (name != null)
			toUpdate.setTitle(name);
		if (timeDuration > 0)
			toUpdate.setTimeDuration(timeDuration);
		if (location != null)
			toUpdate.setLocation(location);
		if (time != null)
			toUpdate.setStartTime(time);
		if (date != null)
			toUpdate.setDate(date);
		if (exercises != null)
			toUpdate.setExercises(exercises);
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}

}
