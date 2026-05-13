package com.ra5.projecte3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra5.projecte3.model.Role;
import com.ra5.projecte3.model.User;
import com.ra5.projecte3.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

    public User findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        return optionalUser.isPresent() ? optionalUser.get() : null;
    }
}