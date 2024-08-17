package com.example.expenses_manage.database.repository;

import com.example.expenses_manage.database.entity.Track;
import com.example.expenses_manage.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
    boolean existsByMonthAndYearAndUser(Integer month, Integer year, User user);

    Track findByMonthAndYearAndUser(Integer month, Integer year, User user);
}
