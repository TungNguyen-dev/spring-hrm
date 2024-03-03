package com.example.hrm.api.dto;

public class UserRequestDTO {

    private final String firstName;
    private final String lastName;

    public UserRequestDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
