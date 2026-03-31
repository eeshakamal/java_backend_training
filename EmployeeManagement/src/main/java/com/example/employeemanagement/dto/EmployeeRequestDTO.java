package com.example.employeemanagement.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EmployeeRequestDTO {

    @NotBlank(message = "Name is required")
    @Pattern(
            // allows 1 to 3 words (max 2 spaces). adjust if you want exactly 1 space.
            regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+){0,2}$",
            message = "Name must contain only letters and maximum 2 spaces"
    )
    private String name;

    @Min(value = 19, message = "Age must be at least 19")
    @Max(value = 60, message = "Age must be at most 60")
    private int age;

    @NotBlank(message = "Designation is required")
    @Pattern(
            regexp = "^(M25|P20|T15)$",
            message = "Designation must be one of: M25, P20, T15"
    )
    private String designation;
    // -------------------------
    // Default Constructor
    // -------------------------

    public EmployeeRequestDTO() {
    }

    // -------------------------
    // Getters
    // -------------------------

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDesignation() {
        return designation;
    }

    // -------------------------
    // Setters
    // -------------------------

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
