package com.example.stiraralka_bot.repository;

import com.example.stiraralka_bot.models.PahaPhraze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional()
public interface PahaPraseRepository extends JpaRepository<PahaPhraze, Integer> {
}
