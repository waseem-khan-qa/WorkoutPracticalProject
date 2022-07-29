package com.waseem.workout.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
public class Workout {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private int timeDuration;
	private String location;
	@NonNull
	@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
	private LocalTime startTime;
	@NonNull
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate date;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Exercise> exercises;
	
	

	public Workout(int id, String title, int timeDuration, String location, @NonNull LocalTime startTime,
			@NonNull LocalDate date, List<Exercise> exercises) {
		super();
		this.id = id;
		this.title = title;
		this.timeDuration = timeDuration;
		this.location = location;
		this.startTime = startTime;
		this.date = date;
		this.exercises = exercises;
	}

	public Workout(String title, int timeDuration, String location, @NonNull LocalTime startTime,
			@NonNull LocalDate date, List<Exercise> exercises) {
		super();
		this.title = title;
		this.timeDuration = timeDuration;
		this.location = location;
		this.startTime = startTime;
		this.date = date;
		this.exercises = exercises;
	}

	public Workout() {
		
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

	public int getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(int timeDuration) {
		this.timeDuration = timeDuration;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	} 	
}
