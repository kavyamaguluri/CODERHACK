package com.crio.coderhack.controllers;

import com.crio.coderhack.dto.User;
import com.crio.coderhack.exchanges.RegisterUserRequest;
import com.crio.coderhack.exchanges.UpdateScoreRequest;
import com.crio.coderhack.exceptions.UserNotFoundException;
import com.crio.coderhack.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/coderhack/api/v1/users") // Base path for all endpoints
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() throws UserNotFoundException {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        try {
            User user = userService.findUser(userId);
            return ResponseEntity.ok().body(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@Valid @RequestBody RegisterUserRequest registerUserRequest) {
    String userId = registerUserRequest.getUserId();
    String username = registerUserRequest.getUsername();
    User user = userService.registerUser(userId, username); // Pass userId to service
    return ResponseEntity.ok().body(user);
}

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateScore(@PathVariable String userId, @Valid @RequestBody UpdateScoreRequest updateScoreRequest) {
        try {
            User user = userService.updateScore(userId, updateScoreRequest.getScore());
            return ResponseEntity.ok().body(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deregisterUser(@PathVariable String userId) {
        try {
            userService.deregisterUser(userId);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}