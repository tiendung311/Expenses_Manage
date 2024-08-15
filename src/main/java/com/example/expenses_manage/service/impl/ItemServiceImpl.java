package com.example.expenses_manage.service.impl;

import com.example.expenses_manage.database.entity.Item;
import com.example.expenses_manage.database.entity.Track;
import com.example.expenses_manage.database.repository.ItemRepository;
import com.example.expenses_manage.model.ItemPostDto;
import com.example.expenses_manage.service.ItemService;
import com.example.expenses_manage.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TrackService trackService;

    @Override
    public void createItem(ItemPostDto request) {
        Item item = new Item();
        item.setName(request.getName());
        item.setCategory(request.getCategory());
        item.setStatus(request.getStatus());
        item.setPrice(request.getPrice());
        item.setNotes(request.getNotes());
        item.setCreatedAt(LocalDateTime.now());

        Track track = trackService.findByMonthAndYear();
        item.setTrack(track);

        itemRepository.save(item);
    }
}
