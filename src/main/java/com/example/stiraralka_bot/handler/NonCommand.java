package com.example.stiraralka_bot.handler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Обработка сообщения, не являющегося командой (т.е. обычного текста не начинающегося с "/")
 */
@Component
public class NonCommand {

    @Autowired
    private PahaTalks pahaTalks;
    @Autowired
    private Top250FilmHandler top250FilmHandler;


    public String nonCommandExecute(Long chatId, String userName, String text) {
        int result = whatToDo(text);
        switch (result){
            case 0: return pahaTalks.tryToFindPaha(text);
            case 1: return top250FilmHandler.getFilm().get();
        }
        return pahaTalks.tryToFindPaha(text);
    }


    private int whatToDo(String text){
        List<String> collect = text.lines().flatMap(x -> Arrays.stream(x.split(" "))).collect(Collectors.toList());
        if(collect.stream().anyMatch(x -> x.equalsIgnoreCase("фильм"))){
            return 1;
        }
        return 0;
    }




}


