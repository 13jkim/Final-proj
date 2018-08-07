package com.john.exercisevue.repository;

import com.john.exercisevue.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByNameAndEmail(String name, String email);
}
