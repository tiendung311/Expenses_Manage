package com.example.expenses_manage.service.impl;

import com.example.expenses_manage.database.entity.Item;
import com.example.expenses_manage.database.entity.Track;
import com.example.expenses_manage.database.repository.ItemRepository;
import com.example.expenses_manage.database.repository.TrackRepository;
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
    private TrackRepository trackRepository;

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

        Track track = trackService.findByMonthAndYearAndUser(request.getUsername());
        item.setTrack(track);

        track.setTotal(track.getTotal() - request.getPrice());
        if (track.getTotal() < 0) {
            track.setStatus("inactive");
        }

        itemRepository.save(item);
    }

    @Override
    public void deleteItem(Integer id) {
        Item item = itemRepository.findByItemId(id);
        itemRepository.delete(item);

        Track track = item.getTrack();
        track.setTotal(track.getTotal() + item.getPrice());
        if (track.getTotal() >= 0) {
            track.setStatus("active");
        }

        trackRepository.save(track);
    }
}
