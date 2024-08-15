package com.example.expenses_manage.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trackId;

    private String name;
    private Integer month;
    private Integer year;
    private Double total;
    private String notes;
    private String status;

    @OneToMany(mappedBy = "track")
    private List<Item> items;
}
