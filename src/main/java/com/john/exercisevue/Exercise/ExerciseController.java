package com.john.exercisevue.Exercise;

import com.john.exercisevue.Workout.Workout;
import com.john.exercisevue.Workout.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    @GetMapping
    public Iterable<Exercise> getAllExercises() {
       return exerciseRepository.findAll();
    }

//    @GetMapping("/{workoutId}")
//    public Iterable<Exercise> getWorkoutExercises(@PathVariable Long workoutId) {
//        return exerciseRepository.findAllByWorkoutId(workoutId);
//    }

    @PostMapping("/{workoutId}")
    public Exercise addExercise(@PathVariable Long workoutId, @RequestBody Exercise exercise) {
        Workout workout = workoutRepository.findById(workoutId).orElse(null);
        workout.getExercises().add(exercise);
        return exerciseRepository.save(exercise);
    }
}
