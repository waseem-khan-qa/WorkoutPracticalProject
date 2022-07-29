package com.waseem.workout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.waseem.workout.entity.Exercise;
import com.waseem.workout.repo.ExerciseRepository;

@Service
@Primary
public class ExerciseServiceDB implements ExerciseService {

	@Autowired
	private ExerciseRepository repo;

	public ExerciseServiceDB(ExerciseRepository repo)
    {
        this.repo = repo;
    }
	@Override
	public Exercise getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Exercise> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Exercise create(Exercise dino) {
		return this.repo.save(dino);
	}

	@Override
	public Exercise update(int id, String name, String desc, int cal, String equip) {
		Exercise toUpdate = this.getById(id);
		if (name != null)
			toUpdate.setTitle(name);
		if (desc != null)
			toUpdate.setExerciseDesc(desc);
		if (cal > 0)
			toUpdate.setCalories(cal);
		if (equip != null)
			toUpdate.setEquipmentDesc(equip);
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public Exercise findByName(String name) {
		return this.repo.findByTitleStartingWithIgnoreCase(name);
	}

}
