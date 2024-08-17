package com.example.expenses_manage.service;

import com.example.expenses_manage.database.entity.Item;
import com.example.expenses_manage.model.ItemPostDto;

import java.util.List;

public interface ItemService {
    List<Item> getAllItemsByMonthAndYearAndUser(Integer month, Integer year, String username);

    void createItem(ItemPostDto request);

    void deleteItem(Integer id);
}
