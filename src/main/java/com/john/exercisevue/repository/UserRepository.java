package com.john.exercisevue.repository;

import com.john.exercisevue.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
