package com.john.exercisevue.service;

import com.john.exercisevue.domain.Exercise;
import com.john.exercisevue.domain.Workout;
import com.john.exercisevue.repository.ExerciseRepository;
import com.john.exercisevue.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import static org.springframework.http.HttpStatus.OK;

@Service
public class ExerciseService {

    private ExerciseRepository exerciseRepository;
    private WorkoutRepository workoutRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository, WorkoutRepository workoutRepository) {
        this.exerciseRepository = exerciseRepository;
        this.workoutRepository = workoutRepository;
    }

    public ResponseEntity<Iterable<Exercise>> getAllExercises() {
        Iterable<Exercise> foundExercises = exerciseRepository.findAll();
        return new ResponseEntity<>(foundExercises, OK);
    }

    public ResponseEntity<Iterable<Exercise>> getExercisesByWorkout(Long workoutId) {
        Workout workout = workoutRepository.findById(workoutId).orElse(null);
        Iterable<Exercise> workoutExercises = workout.getExercises();
        return new ResponseEntity<>(workoutExercises, OK);
    }


}
