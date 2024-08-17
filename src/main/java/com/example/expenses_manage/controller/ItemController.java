package com.example.expenses_manage.controller;

import com.example.expenses_manage.model.ItemPostDto;
import com.example.expenses_manage.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody ItemPostDto request) {
        itemService.createItem(request);
        return ResponseEntity.ok("Item added successfully");
    }
}
