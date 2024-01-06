package com.alitafreshi.task_manager.user.service;

import com.alitafreshi.task_manager.user.model.User;
import com.alitafreshi.task_manager.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User insertNewUser(User newUser) {
        return userRepository.save(newUser);
    }

    public Long deleteUser(String phoneNumber) {
        return userRepository.deleteByPhoneNumber(phoneNumber);
    }

    public User findUserByPhoneNumber(String phoneNumber) {
        return userRepository.findUserByPhoneNumber(phoneNumber);
    }

}
