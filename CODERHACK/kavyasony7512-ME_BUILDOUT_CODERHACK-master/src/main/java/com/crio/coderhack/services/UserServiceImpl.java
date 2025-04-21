package com.crio.coderhack.services;


import com.crio.coderhack.dto.User;
import com.crio.coderhack.exceptions.UserNotFoundException;
import com.crio.coderhack.models.UserEntity;
import com.crio.coderhack.repositories.UserRepository;
import com.crio.coderhack.repositoryServices.UserRepositoryServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryServices userRepositoryServices;

    @Autowired
    private ModelMapper modelMapper;

    
    @Override
public User registerUser(String userId, String username) {
    UserEntity userEntity = new UserEntity();
    userEntity.setUserId(userId); // Set user-provided userId
    userEntity.setUsername(username);
    userEntity.setScore(0);
    userEntity.setBadges(new ArrayList<>());
    return modelMapper.map(userRepository.save(userEntity), User.class);
}

    @Override
    public User updateScore(String userId, int score) throws UserNotFoundException {
        return userRepositoryServices.updateScore(userId, score);
    }

    @Override
    public User findUser(String userId) throws UserNotFoundException {
        return userRepositoryServices.findUser(userId);
    }

    @Override
    public List<User> findAllUsers() throws UserNotFoundException {
        return userRepositoryServices.findAllUsers();
    }

    @Override
    public void deregisterUser(String userId) throws UserNotFoundException {
        userRepositoryServices.deleteUser(userId);
    }
}