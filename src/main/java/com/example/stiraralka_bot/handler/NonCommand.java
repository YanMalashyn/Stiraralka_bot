package com.example.stiraralka_bot.handler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Обработка сообщения, не являющегося командой (т.е. обычного текста не начинающегося с "/")
 */
@Component
public class NonCommand {

    @Autowired
    private TalksLikePahaImpl talksLikePahaImpl;
    @Autowired
    private Top250FilmImpl top250FilmImpl;
    @Autowired
    private PornoFromPornHub pornoFromPornHub;

    public String nonCommandExecute(Long chatId, String userName, String text) {
        Map<BotAbilityEnum,String> map = new HashMap<>();
        map.put(BotAbilityEnum.SPEAK_LIKE_PAHA, talksLikePahaImpl.getResponse(text, userName));
        map.put(BotAbilityEnum.GET_RANDOM_Film, top250FilmImpl.getResponse(text, userName));
        map.put(BotAbilityEnum.GET_RANDOM_PORNO, pornoFromPornHub.getResponse(text, userName));
        return responseConstructor(map, userName);


    }


    private String responseConstructor(Map<BotAbilityEnum, String> map, String userName){
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<BotAbilityEnum> iterator = Arrays.stream(BotAbilityEnum.values()).iterator();
        while (iterator.hasNext()){
            BotAbilityEnum next = iterator.next();
            if(!map.get(next).equals("")){
                stringBuilder.append(userName).append(", ").append(map.get(next));
                return stringBuilder.toString();
            }
        }
        return "";
    }


}


