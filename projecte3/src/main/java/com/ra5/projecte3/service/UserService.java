package com.ra5.projecte3.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra5.projecte3.dto.UserRequestDTO;
import com.ra5.projecte3.dto.UserResponseDTO;
import com.ra5.projecte3.mapper.UserMapper;
import com.ra5.projecte3.model.AcademicProfile;
import com.ra5.projecte3.model.Role;
import com.ra5.projecte3.model.User;
import com.ra5.projecte3.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

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

    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        if (userRepository.findByEmail(userRequestDTO.getEmail()).isEmpty()) {
            return null;
        }

        User user = userMapper.toEntity(userRequestDTO);

        userRepository.save(user);

        return userMapper.toDto(user);
    }

    public UserResponseDTO update(String id, UserRequestDTO userRequestDTO) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();
        user.setEmail(userRequestDTO.getEmail() != null ? userRequestDTO.getEmail() : user.getEmail());
        user.setPassword(userRequestDTO.getPassword() != null ? userRequestDTO.getPassword() : user.getPassword());
        user.setUsername(userRequestDTO.getUsername() != null ? userRequestDTO.getUsername() : user.getUsername());
        user.setFirstName(userRequestDTO.getFirstName() != null ? userRequestDTO.getFirstName() : user.getFirstName());
        user.setLastName(userRequestDTO.getLastName() != null ? userRequestDTO.getLastName() : user.getLastName());
        user.setRole(userRequestDTO.getRole() != null ? userRequestDTO.getRole() : user.getRole());

        user.getAcademicProfile().setGrade(userRequestDTO.getGrade() != null ? userRequestDTO.getGrade() : user.getAcademicProfile().getGrade());
        user.getAcademicProfile().setObservations(userRequestDTO.getObservations() != null ? userRequestDTO.getObservations() : user.getAcademicProfile().getObservations());

        userRepository.save(user);

        return userMapper.toDto(user);
    }

    public Boolean delete(String id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            return false;
        }

        userRepository.delete(optionalUser.get());

        return true;
    }
}