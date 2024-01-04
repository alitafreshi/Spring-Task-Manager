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

    public void insertNewUser(User newUser) {
        userRepository.save(newUser);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void findUserByPhoneNumber(String phoneNumber){
       userRepository.findUserByPhoneNumber(phoneNumber);
    }

}
