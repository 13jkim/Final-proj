package com.john.exercisevue.service;

import com.john.exercisevue.domain.User;
import com.john.exercisevue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.OK;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> createUser(User user) {
        User returnedUser = userRepository.save(user);
        return new ResponseEntity<>(returnedUser, OK);
    }
}
