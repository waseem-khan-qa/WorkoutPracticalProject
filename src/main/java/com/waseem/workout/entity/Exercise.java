package com.waseem.workout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Exercise {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	@Lob
	private String exerciseDesc;
	private int calories;
	@Lob
	private String equipmentDesc;
	
	public Exercise(int id, String title, String exerciseDesc, int calories, String equipmentDesc) {
		super();
		this.id = id;
		this.title = title;
		this.exerciseDesc = exerciseDesc;
		this.calories = calories;
		this.equipmentDesc = equipmentDesc;
	}
	public Exercise(String title, String exerciseDesc, int calories, String equipmentDesc) {
		super();
		this.title = title;
		this.exerciseDesc = exerciseDesc;
		this.calories = calories;
		this.equipmentDesc = equipmentDesc;
	}
	
	public Exercise() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExerciseDesc() {
		return exerciseDesc;
	}
	public void setExerciseDesc(String exerciseDesc) {
		this.exerciseDesc = exerciseDesc;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getEquipmentDesc() {
		return equipmentDesc;
	}
	public void setEquipmentDesc(String equipmentDesc) {
		this.equipmentDesc = equipmentDesc;
	}
}
