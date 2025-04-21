package com.crio.coderhack.repositoryServices;

import java.util.List;
import com.crio.coderhack.dto.User;
import com.crio.coderhack.exceptions.UserNotFoundException;

public interface UserRepositoryServices {
    User createUser(String username);
    User updateScore(String userId, int score) throws UserNotFoundException;
    User findUser(String userId) throws UserNotFoundException;
    void deleteUser(String userId) throws UserNotFoundException;
    List<User> findAllUsers();
}
