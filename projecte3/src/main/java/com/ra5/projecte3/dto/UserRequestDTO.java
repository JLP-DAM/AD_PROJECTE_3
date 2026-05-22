package com.ra5.projecte3.dto;

import com.ra5.projecte3.model.Role;

public class UserRequestDTO {
    private String email;
    private String username;

    private String firstName;
    private String lastName;
    private String password;
    private Role role;
    private String observations;
    private String grade;

    public UserRequestDTO() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "UserRequestDTO [email=" + email + ", username=" + username + ", firstName=" + firstName + ", lastName="
                + lastName + ", password=" + password + ", role=" + role + ", observations=" + observations + ", grade="
                + grade + "]";
    }    
}

