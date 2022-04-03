package com.example.stiraralka_bot.handler;

import com.example.stiraralka_bot.service.Top250filmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Top250FilmHandler {
    @Autowired
    private Top250filmService top250filmService;

    public Optional<String> getFilm(){
        int id = (int) Math.round(Math.random()*2);
        return top250filmService.getFilmById(id);
    }

}
