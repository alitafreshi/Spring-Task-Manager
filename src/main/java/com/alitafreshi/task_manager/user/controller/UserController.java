package com.alitafreshi.task_manager.user.controller;

import com.alitafreshi.task_manager.user.model.User;
import com.alitafreshi.task_manager.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User Apis")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/newUser")
    @Operation(summary = "insert new user into database")
    public User insertNewUser(@RequestBody User newUser) {
        return userService.insertNewUser(newUser);
    }

    @DeleteMapping("/delete")
    @Transactional
    @Operation(summary = "remove user from database with phone number")
    public String deleteUser(@RequestParam String userPhoneNumber) {
        if (userService.deleteUser(userPhoneNumber) > 0) {
            return "User With Phone Number " + " " + userPhoneNumber + " " + "Deleted";
        }
        return "There Is No User With Phone Number" + " " + userPhoneNumber + " " + " Founded";
    }

    @GetMapping("{userPhoneNumber}")
    @Operation(summary = "retrieve user info by user phone number")
    public User getUserInfo(@PathVariable("userPhoneNumber") String phoneNumber) {
        return userService.findUserByPhoneNumber(phoneNumber);
    }
}
