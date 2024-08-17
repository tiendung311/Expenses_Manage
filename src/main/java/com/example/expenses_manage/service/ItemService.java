package com.example.expenses_manage.service;

import com.example.expenses_manage.model.ItemPostDto;

public interface ItemService {
    void createItem(ItemPostDto request);

    void deleteItem(Integer id);
}
