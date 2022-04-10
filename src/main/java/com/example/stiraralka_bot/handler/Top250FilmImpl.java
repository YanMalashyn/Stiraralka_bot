package com.example.stiraralka_bot.handler;

import com.example.stiraralka_bot.service.Top250filmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Top250FilmImpl implements AbstractBotAbility {
    @Autowired
    private Top250filmService top250filmService;

    @Override
    public String getResponse(String s) {
        List<String> collect = s.lines().flatMap(x -> Arrays.stream(x.split(" "))).collect(Collectors.toList());
        if(collect.stream().anyMatch(x -> x.equalsIgnoreCase("фильм"))){
            int id = 1 + (int) Math.round(Math.random()*2);
            return top250filmService.getFilmById(id).get();
        }
        return "";
    }
}
