package com.example.expenses_manage.scheduler;

import com.example.expenses_manage.database.entity.Track;
import com.example.expenses_manage.database.entity.User;
import com.example.expenses_manage.database.repository.UserRepository;
import com.example.expenses_manage.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Component
public class TrackScheduler {
    @Autowired
    private TrackService trackService;

    @Autowired
    private UserRepository userRepository;

    private static final Logger log = Logger.getLogger(TrackScheduler.class.getName());

    // Create a new track every month
//    @Scheduled(cron = "0 0 0 1 * ?")
    @Scheduled(cron = "0 * * * * ?")  // For testing every minute
    public void createTrack() {
        log.info("Creating a new track...");

        LocalDate now = LocalDate.now();
        Integer month = now.getMonthValue();
        Integer year = now.getYear();
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (!trackService.existsByMonthAndYearAndUser(month, year, user)) {
                log.info("Creating new track for month: " + month + ", year: " + year);

                Track track = new Track();
                track.setName("Track " + month + "/" + year);
                track.setMonth(month);
                track.setYear(year);
                track.setTotal(user.getTotal());
                track.setStatus("active");
                track.setNotes("");
                track.setUser(user);

                trackService.saveTrack(track);

                log.info("New track created for " + user.getFullName() + " successfully!");
            } else {
                log.info("Track already exists for month: " + month + ", year: " + year);
            }
        }
    }
}
