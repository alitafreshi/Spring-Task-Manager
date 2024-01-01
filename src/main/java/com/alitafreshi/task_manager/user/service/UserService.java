package com.alitafreshi.task_manager.user.service;

import com.alitafreshi.task_manager.user.model.User;
import com.alitafreshi.task_manager.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void insertNewUser(User newUser) {
        userRepository.save(newUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("user with id" + userId + "dose not exist");
        }
        userRepository.deleteById(userId);
    }


}

