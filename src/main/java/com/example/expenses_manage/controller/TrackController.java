package com.example.expenses_manage.controller;

import com.example.expenses_manage.database.entity.Track;
import com.example.expenses_manage.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {
    @Autowired
    private TrackService trackService;

    @GetMapping("/all")
    public List<Track> getAllByUser(@RequestParam String username) {
        return trackService.getAllTracksByUser(username);
    }
}
