package com.john.exercisevue.controller;

import com.john.exercisevue.repository.ExerciseRepository;
import com.john.exercisevue.domain.Workout;
import com.john.exercisevue.repository.WorkoutRepository;
import com.john.exercisevue.domain.Exercise;
import com.john.exercisevue.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Exercise>> getAllExercises() {
        return exerciseService.getAllExercises();
    }

}
