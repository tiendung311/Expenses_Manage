package com.example.expenses_manage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {
    private String fullName;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;
    private LocalDate dob;
    private Double total;
}
