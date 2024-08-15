package com.example.expenses_manage.database.repository;

import com.example.expenses_manage.database.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
}
