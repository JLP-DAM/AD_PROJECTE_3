package com.ra5.projecte3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ra5.projecte3.model.Role;
import com.ra5.projecte3.model.User;
import com.ra5.projecte3.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<String> findAll() {
        return ResponseEntity.status(200).body(userService.findAll().toString());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable("id") String id) {
        User user = userService.findById(id);

        return ResponseEntity.status(user == null ? 404 : 200).body(user == null ? "User no trobat" : user.toString());
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<String> findByRole(@PathVariable("role") Role role) {
        return ResponseEntity.status(200).body(userService.findByRole(role).toString());
    }

    @GetMapping("/usernames/{username}")
    public ResponseEntity<String> findByUsername(@PathVariable("username") String username) {
        User user = userService.findByUsername(username);

        return ResponseEntity.status(user == null ? 404 : 200).body(user == null ? "User no trobat" : user.toString());
    }
}
