package com.waseem.workout.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.waseem.workout.repo.ExerciseRepository;
import com.waseem.workout.service.ExerciseService;

@SpringBootTest
@Sql(scripts = { "classpath:workout-schema.sql",
		"classpath:workout-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ExerciseControllerTest {

    @Mock private ExerciseRepository exerciseRepository;

    @Autowired
    private ExerciseService exerciseService;

	private int add(int a, int b) {
		return a + b;
	}

	@Test
	void testDemo() {
		assertEquals(2, add(1, 1));
	}
	
	@Test void getWorkoutByID()
    {
		Exercise testExercise = new Exercise(1, "E1", "Excercise 1", 10, "No Equipment");
		assertEquals(testExercise.getId(), exerciseService.getById(testExercise.getId()).getId());
    }
	@Test void getAll()
    {
		assertEquals(4, exerciseService.getAll().size());
    }
	
	@Test void create()
    {
		Exercise testExercise = new Exercise("E1", "Excercise 1", 10, "No Equipment");
		assertEquals(5, exerciseService.create(testExercise).getId());
    }

	@Test void update()
    {
		Exercise testExercise = exerciseService.getById(2);
		testExercise.setTitle("Update Name");
		assertEquals(testExercise.getTitle(), exerciseService.update(testExercise.getId(), testExercise.getTitle(), testExercise.getExerciseDesc(), testExercise.getCalories(), testExercise.getEquipmentDesc()).getTitle());
    }

	@Test
    public void destroy() {
		exerciseService.delete(exerciseService.getAll().size());
    }
	
	
	

}
