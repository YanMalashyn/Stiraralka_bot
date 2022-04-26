package com.example.stiraralka_bot.responseSenders;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("молодец")
public class RandomBestGaySender implements Sender{
    private static final List<String> list =
            List.of("Саша", "Серго", "Ян","Стас", "Леха", "Жека", "Рома", "Олежка", "Зубец", "Настя","все плохие=(");
    @Override
    public String sendResponse() {
        int id = (int) Math.round(Math.random()*list.size()-1);
        if(id == 10){
            return list.get(10);
        }
        return "Самый лучший " + list.get(id);
    }
}
