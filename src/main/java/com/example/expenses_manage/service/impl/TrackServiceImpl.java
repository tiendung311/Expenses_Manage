package com.example.expenses_manage.service.impl;

import com.example.expenses_manage.database.entity.Track;
import com.example.expenses_manage.database.entity.User;
import com.example.expenses_manage.database.repository.TrackRepository;
import com.example.expenses_manage.database.repository.UserRepository;
import com.example.expenses_manage.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean existsByMonthAndYearAndUser(Integer month, Integer year, User user) {
        return trackRepository.existsByMonthAndYearAndUser(month, year, user);
    }

    @Override
    public void saveTrack(Track track) {
        trackRepository.save(track);
    }

    @Override
    public Track findByMonthAndYearAndUser(String username) {
        LocalDate date = LocalDate.now();
        Integer month = date.getMonthValue();
        Integer year = date.getYear();

        User user = userRepository.findByUsername(username);

        return trackRepository.findByMonthAndYearAndUser(month, year, user);
    }

    @Override
    public List<Track> getAllTracksByUser(String username) {
        User user = userRepository.findByUsername(username);

        return trackRepository.findAllByUser(user);
    }
}
