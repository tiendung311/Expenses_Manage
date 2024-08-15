package com.example.expenses_manage.service.impl;

import com.example.expenses_manage.database.entity.Track;
import com.example.expenses_manage.database.repository.TrackRepository;
import com.example.expenses_manage.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    private TrackRepository trackRepository;

    @Override
    public boolean existsByMonthAndYear(Integer month, Integer year) {
        return trackRepository.existsByMonthAndYear(month, year);
    }

    @Override
    public void saveTrack(Track track) {
        trackRepository.save(track);
    }

    @Override
    public Track findByMonthAndYear() {
        LocalDate date = LocalDate.now();
        Integer month = date.getMonthValue();
        Integer year = date.getYear();

        return trackRepository.findByMonthAndYear(month, year);
    }
}
