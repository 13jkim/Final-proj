package com.john.exercisevue.Workout;

import com.john.exercisevue.Exercise.Exercise;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @NotNull
    @Column(name = "workout_name", unique = true, length = 100)
    private String workoutName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE
    })
    @JoinTable(name = "workout_exercise", joinColumns = { @JoinColumn(name = "workout_id")},
            inverseJoinColumns = { @JoinColumn(name = "exercise_id")})
    @EqualsAndHashCode.Exclude
    private Set<Exercise> exercises = new HashSet<>();

    public Workout(@NotNull String workoutName) {
        this.workoutName = workoutName;
    }
}
