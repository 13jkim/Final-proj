package com.john.exercisevue.Workout;

import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutRepository workoutRepository;

    @GetMapping
    public Iterable<Workout> findAllWorkouts() {
        return workoutRepository.findAll();
    }

    @GetMapping("/{workoutId}")
    public Workout findWorkoutById(@PathVariable Long workoutId) {
        return workoutRepository.findById(workoutId).orElse(null);
    }

    @PostMapping
    public Workout addWorkout(@RequestBody Workout workout) {
        return workoutRepository.save(workout);
    }
}
