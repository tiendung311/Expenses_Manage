package com.example.expenses_manage.scheduler;

import com.example.expenses_manage.database.entity.Track;
import com.example.expenses_manage.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.logging.Logger;

@Component
public class TrackScheduler {
    @Autowired
    private TrackService trackService;

    private static final Logger log = Logger.getLogger(TrackScheduler.class.getName());

    // Create a new track every month
    @Scheduled(cron = "0 0 0 1 * ?")
//    @Scheduled(cron = "0 * * * * ?")  // For testing every minute
    public void createTrack() {
        log.info("Creating a new track...");

        LocalDate now = LocalDate.now();
        Integer month = now.getMonthValue();
        Integer year = now.getYear();

        if (!trackService.existsByMonthAndYear(month, year)) {
            log.info("Creating new track for month: " + month + ", year: " + year);

            Track track = new Track();
            track.setName("Track " + month + "/" + year);
            track.setMonth(month);
            track.setYear(year);
            track.setTotal(5000000.0);
            track.setStatus("active");
            track.setNotes("");

            trackService.saveTrack(track);

            log.info("New track created successfully!");
        } else {
            log.info("Track already exists for month: " + month + ", year: " + year);
        }
    }
}
