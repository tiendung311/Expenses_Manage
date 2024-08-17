package com.example.expenses_manage.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String fullName;
    private String email;
    private String password;
    private LocalDate dob;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "user")
    private List<Track> tracks;
}
