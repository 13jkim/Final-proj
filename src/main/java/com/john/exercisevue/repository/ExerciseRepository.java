package com.john.exercisevue.repository;

import com.john.exercisevue.domain.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    Iterable<Exercise> findAllByWorkoutId(Long workoutId);
}
