package com.john.exercisevue.service;

import com.john.exercisevue.domain.User;
import com.john.exercisevue.domain.Workout;
import com.john.exercisevue.repository.UserRepository;
import com.john.exercisevue.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import static org.springframework.http.HttpStatus.OK;

@Service
public class WorkoutService {

    private WorkoutRepository workoutRepository;
    private UserRepository userRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository, UserRepository userRepository) {
        this.workoutRepository = workoutRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Iterable<Workout>> getAllWorkouts() {
        Iterable<Workout> allWorkouts = workoutRepository.findAll();
        return new ResponseEntity<>(allWorkouts, OK);
    }

    public ResponseEntity<Iterable<Workout>> getAllWorkoutsByUser(Long userId) {
        return new ResponseEntity<>(workoutRepository.findByUserId(userId), OK);
    }

    public ResponseEntity<Workout> createWorkout(Long userId, Workout workout) {
        User user = userRepository.findById(userId).orElse(null);
        workout.setUser(user);
        Workout returnedWorkout = workoutRepository.save(workout);
        return new ResponseEntity<>(returnedWorkout, OK);
    }
}
