package com.crio.coderhack.services;

import java.util.List;
import com.crio.coderhack.dto.User;
import com.crio.coderhack.exceptions.UserNotFoundException;

public interface UserService {
    User registerUser(String userId, String username);
    User updateScore(String userId, int score) throws UserNotFoundException;
    User findUser(String userId)throws UserNotFoundException;
    List<User> findAllUsers() throws UserNotFoundException;
    void deregisterUser(String userId) throws UserNotFoundException;
}
