package com.example.stiraralka_bot.repository;

import com.example.stiraralka_bot.models.Top250film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface  Top250filmRepository extends JpaRepository<Top250film, Integer> {
}
