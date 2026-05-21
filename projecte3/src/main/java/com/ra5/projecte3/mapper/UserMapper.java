package com.ra5.projecte3.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.ra5.projecte3.dto.AcademicProfileDTO;
import com.ra5.projecte3.dto.UserRequestDTO;
import com.ra5.projecte3.dto.UserResponseDTO;
import com.ra5.projecte3.model.AcademicProfile;
import com.ra5.projecte3.model.User;

@Component
public class UserMapper {
    public UserResponseDTO toDto(User user) {
        if (user == null) {return null;}

        UserResponseDTO userReponseDTO = new UserResponseDTO();
        userReponseDTO.setId(user.getId());
        userReponseDTO.setEmail(user.getEmail());
        userReponseDTO.setUsername(user.getUsername());
        userReponseDTO.setFirstName(user.getFirstName());
        userReponseDTO.setLastName(user.getLastName());
        userReponseDTO.setRole(user.getRole());
        userReponseDTO.setId(user.getId());
        userReponseDTO.setEmail(user.getEmail());
        userReponseDTO.setDataCreated(user.getDataCreated());
        userReponseDTO.setAcademicProfile(user.getAcademicProfile() != null ? toDto(user.getAcademicProfile()) : null);

        return userReponseDTO;
    }

    public AcademicProfileDTO toDto(AcademicProfile academicProfile) {
        if (academicProfile == null) {return null;}
 
        AcademicProfileDTO academicProfileDTO = new AcademicProfileDTO();
        academicProfileDTO.setCourse(academicProfile.getCourse());
        academicProfileDTO.setGrade(academicProfile.getGrade());
        academicProfileDTO.setObservations(academicProfile.getObservations());
        academicProfileDTO.setStatus(academicProfile.getStatus());

        return academicProfileDTO;
    }

    public User toEntity(UserRequestDTO userRequestDTO) {
        if (userRequestDTO == null) {return null;}

        User user = new User();
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setUsername(userRequestDTO.getUsername());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setRole(userRequestDTO.getRole());
        user.setEmail(userRequestDTO.getEmail());
        user.setDataCreated(LocalDateTime.now());

        if (userRequestDTO.getGrade() == null) {
            AcademicProfile academicProfile = new AcademicProfile();
            academicProfile.setGrade(userRequestDTO.getGrade());
            academicProfile.setObservations(userRequestDTO.getObservations());
        }

        return user;
    }
}
