package com.john.exercisevue.Exercise;

import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
//    Iterable<Exercise> findAllByWorkoutId(Long workoutId);
}
