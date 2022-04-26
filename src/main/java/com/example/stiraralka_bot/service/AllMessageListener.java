package com.example.stiraralka_bot.service;

import com.example.stiraralka_bot.responseSenders.Sender;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class AllMessageListener {

    private static Map<String, Sender> senderMap;

    @Autowired
    public void setMap(Map<String, Sender> senderMap){
        AllMessageListener.senderMap = senderMap;
    }

    public String getResponce(String author, String message){
       for(Map.Entry<String, Long> entry: filterMessage(message).entrySet()){
           if(entry.getValue() > 0){
               for(Map.Entry<String, Sender> senderEntry: senderMap.entrySet()){
                    if(senderEntry.getKey().equals(entry.getKey())){
                       return author + "," + senderEntry.getValue().sendResponse();
                    }
               }
           }
       }
       return "";
    }


     static Map<String, Long> filterMessage(String message){
        return Arrays.stream(message.split(" "))
                .map(String::toLowerCase)
                .distinct()
                .filter(AllMessageListener::containsMarkedWord)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

      static boolean containsMarkedWord(String word){
        for(Map.Entry<String, Sender> senderEntry: senderMap.entrySet()){
            if(senderEntry.getKey().equals(word)){
                return true;
            }
        }
        return false;
    }
}
