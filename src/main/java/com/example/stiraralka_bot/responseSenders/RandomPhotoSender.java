package com.example.stiraralka_bot.responseSenders;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("фото")
public class RandomPhotoSender implements Sender {
    @Override
    public String sendResponse() {
        Random random = new Random();
        return "https://loremflickr.com/1000/1000/" + random.nextInt(1000);
    }
}
