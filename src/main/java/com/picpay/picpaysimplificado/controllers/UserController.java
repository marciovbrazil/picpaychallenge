package com.picpay.picpaysimplificado.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.picpay.picpaysimplificado.domain.user.User;
import com.picpay.picpaysimplificado.dtos.UserDTO;
import com.picpay.picpaysimplificado.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserController
 */
@RestController()
@RequestMapping("/users")

public class UserController {

    public final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        User newUser = this.userService.createUser(user);
        
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    
}