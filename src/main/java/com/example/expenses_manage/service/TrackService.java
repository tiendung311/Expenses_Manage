package com.example.expenses_manage.service;

import com.example.expenses_manage.database.entity.Track;
import com.example.expenses_manage.database.entity.User;

import java.util.List;

public interface TrackService {
    boolean existsByMonthAndYearAndUser(Integer month, Integer year, User user);

    void saveTrack(Track track);

    Track findByMonthAndYearAndUser(String username);

    List<Track> getAllTracksByUser(String username);
}
