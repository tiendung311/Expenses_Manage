package com.example.expenses_manage.database.repository;

import com.example.expenses_manage.database.entity.Item;
import com.example.expenses_manage.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
    Item findByItemId(Integer itemId);

    @Query("SELECT i FROM Item i WHERE i.track.month = :month AND i.track.year = :year AND i.track.user = :user")
    List<Item> findAllItemsByMonthAndYearAndUser(Integer month, Integer year, User user);
}
