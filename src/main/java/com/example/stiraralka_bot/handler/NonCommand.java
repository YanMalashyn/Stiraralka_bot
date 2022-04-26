package com.example.stiraralka_bot.handler;

import com.example.stiraralka_bot.service.AllMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Обработка сообщения, не являющегося командой (т.е. обычного текста не начинающегося с "/")
 */
@Component
public class NonCommand {

    @Autowired
    AllMessageListener allMessageListener;

    public String nonCommandExecute(Long chatId, String userName, String text) {
        return allMessageListener.getResponce(userName, text);
    }

}


