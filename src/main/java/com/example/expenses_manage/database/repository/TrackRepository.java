package com.example.expenses_manage.database.repository;

import com.example.expenses_manage.database.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
    boolean existsByMonthAndYear(Integer month, Integer year);

    Track findByMonthAndYear(Integer month, Integer year);
}
