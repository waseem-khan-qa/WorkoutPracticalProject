package com.waseem.workout.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import com.waseem.workout.entity.Exercise;
import com.waseem.workout.entity.Workout;
import com.waseem.workout.repo.WorkoutRepository;
import com.waseem.workout.service.WorkoutService;

@SpringBootTest
@Sql(scripts = { "classpath:workout-schema.sql",
		"classpath:workout-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class WorkoutControllerTest {

    @Mock private WorkoutRepository workoutRep;

    @Autowired
    private WorkoutService workoutService;

	private int add(int a, int b) {
		return a + b;
	}

	@Test
	void testDemo() {
		assertEquals(2, add(1, 1));
	}
	
	@Test void getWorkoutByID()
    {
		Workout testWorkout = new Workout(1, "W1", 10, "Any", LocalTime.of(11, 15), LocalDate.of(2022,Month.of(1), 20), new ArrayList<Exercise>());
		assertEquals(testWorkout.getId(), workoutService.getById(testWorkout.getId()).getId());
    }
	@Test void getAll()
    {
		assertEquals(2, workoutService.getAll().size());
    }
	
	@Test void create()
    {
		Workout testWorkout = new Workout("W1", 10, "Any", LocalTime.of(11, 15), LocalDate.of(2022,Month.of(1), 20), new ArrayList<Exercise>());
		assertEquals(3, workoutService.create(testWorkout).getId());
    }

	@Test void update()
    {
		Workout testWorkout = workoutService.getById(2);
		testWorkout.setTitle("Update Name");
		assertEquals(testWorkout.getTitle(), workoutService.update(testWorkout.getId(), testWorkout.getTitle(), testWorkout.getTimeDuration(), testWorkout.getLocation(), testWorkout.getStartTime(), testWorkout.getDate(), testWorkout.getExercises()).getTitle());
    }

	@Test
    public void destroy() {
		workoutService.delete(workoutService.getAll().size());
    }
	
	
	

}
