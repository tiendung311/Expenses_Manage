package com.example.expenses_manage.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trackId;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double total;
    private String notes;
    private String status;

    @OneToMany(mappedBy = "track")
    private List<Item> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
}
