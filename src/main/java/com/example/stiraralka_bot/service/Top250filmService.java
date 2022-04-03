package com.example.stiraralka_bot.service;

import com.example.stiraralka_bot.repository.Top250filmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Top250filmService {
    @Autowired
    Top250filmRepository top250filmRepository;

    public Optional<String> getFilmById(int id){
        Optional<String> s = Optional.of(top250filmRepository.getById(id).getName());
        return s;
    }
}
