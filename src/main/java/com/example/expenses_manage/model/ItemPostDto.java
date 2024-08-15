package com.example.expenses_manage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPostDto {
    private String name;
    private String category;
    private String status;
    private Double price;
    private String notes;
}
