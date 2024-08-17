package com.example.expenses_manage.controller;

import com.example.expenses_manage.database.entity.Item;
import com.example.expenses_manage.database.repository.ItemRepository;
import com.example.expenses_manage.model.ItemPostDto;
import com.example.expenses_manage.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/all")
    public List<Item> getAllItemsByMonthAndYearAndUser(@RequestParam Integer month,
                                                       @RequestParam Integer year,
                                                       @RequestParam String username) {
        return itemService.getAllItemsByMonthAndYearAndUser(month, year, username);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody ItemPostDto request) {
        itemService.createItem(request);
        return ResponseEntity.ok("Item added successfully");
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("Item id is required");
        } else if (!itemRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Item not found");
        }
        itemService.deleteItem(id);
        return ResponseEntity.ok("Item deleted successfully");
    }
}
