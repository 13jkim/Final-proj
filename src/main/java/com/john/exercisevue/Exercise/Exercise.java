package com.john.exercisevue.Exercise;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @NotNull
    @Column(name = "exercise_name", unique = true, length = 100)
    private String exerciseName;

    public Exercise(@NotNull String exerciseName) {
        this.exerciseName = exerciseName;
    }
}
