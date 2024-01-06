package com.alitafreshi.task_manager.user.controller;

import com.alitafreshi.task_manager.user.model.User;
import com.alitafreshi.task_manager.user.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/newUser")
    public User insertNewUser(@RequestBody User newUser) {
        return userService.insertNewUser(newUser);
    }

    @DeleteMapping("/delete")
    @Transactional
    public String deleteUser(@RequestParam String userPhoneNumber) {
        if (userService.deleteUser(userPhoneNumber) > 0) {
            return "User With Phone Number " + " " + userPhoneNumber + " " + "Deleted";
        }
        return "There Is No User With Phone Number" + " " + userPhoneNumber + " " + " Deleted";
    }

    @GetMapping("{userPhoneNumber}")
    public User getUserInfo(@PathVariable("userPhoneNumber") String phoneNumber) {
        return userService.findUserByPhoneNumber(phoneNumber);
    }
}
