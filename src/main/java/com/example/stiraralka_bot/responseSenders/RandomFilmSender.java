package com.example.stiraralka_bot.responseSenders;

import com.example.stiraralka_bot.service.Top250filmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("фильм")
public class RandomFilmSender implements Sender{

    @Autowired
    private Top250filmService top250filmService;

    @Override
    public String sendResponse() {
        int id = 1 + (int) Math.round(Math.random()*249);
        return "норм фильмец: "+ top250filmService.getFilmById(id).get();
    }
}
