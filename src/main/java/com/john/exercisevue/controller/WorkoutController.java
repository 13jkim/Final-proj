package com.john.exercisevue.controller;

import com.john.exercisevue.domain.Workout;
import com.john.exercisevue.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Workout>> findAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Iterable<Workout>> findAllWorkoutsByUserId(@PathVariable Long userId) {
        return workoutService.getAllWorkoutsByUser(userId);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Workout> addWorkout(@PathVariable Long userId, @RequestBody Workout workout) {
        return workoutService.createWorkout(userId, workout);
    }
}
