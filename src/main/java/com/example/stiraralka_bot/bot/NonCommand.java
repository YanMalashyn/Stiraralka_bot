package com.example.stiraralka_bot.bot;


import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Обработка сообщения, не являющегося командой (т.е. обычного текста не начинающегося с "/")
 */
@Component
public class NonCommand {
    public String nonCommandExecute(Long chatId, String userName, String text) {
        return tryToFindPaha(text);
    }


    private String tryToFindPaha(String text){
        long count = text.lines()
                .flatMap(x -> Arrays.stream(x.split(" ")))
                .flatMap(x -> Arrays.stream(x.split(",")))
                .flatMap(x -> Arrays.stream(x.split("!")))
                .flatMap(x -> Arrays.stream(x.split("\\.")))
                .filter(x -> x.equals("Паха") || x.equals("Пахе") || x.equals("паха") || x.equals("пахе")).count();
        if(count > 0) return "Ебать ту Люсю";
        return "";
    }


}
