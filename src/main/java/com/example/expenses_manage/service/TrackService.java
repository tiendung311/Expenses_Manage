package com.example.expenses_manage.service;

import com.example.expenses_manage.database.entity.Track;

public interface TrackService {
    boolean existsByMonthAndYear(Integer month, Integer year);

    void saveTrack(Track track);

    Track findByMonthAndYear();
}
