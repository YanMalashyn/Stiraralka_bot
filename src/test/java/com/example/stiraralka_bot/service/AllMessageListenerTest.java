//package com.example.stiraralka_bot.service;
//
//import com.example.stiraralka_bot.bot.Stiraralka;
//import com.example.stiraralka_bot.responseSenders.Sender;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class AllMessageListenerTest {
//    private static final List<String> list = List.of("паха, порно, фильм");
//
//
//    @Test
//    void getResponce() {
//        String message = "порно";
//        for(Map.Entry<String, Long> entry: filterMessage(message).entrySet()){
//            if(entry.getValue() > 0){
//                for(Map.Entry<String, Sender> senderEntry: senderMap.entrySet()){
//                    if(senderEntry.getKey().equals(entry.getKey())){
//                        return author + "," + senderEntry.getValue().sendResponse();
//                    }
//                }
//            }
//        }
//        return "";
//    }
//
//    @Test
//    void filterMessage() {
//    }
//
//    @Test
//    void containsMarkedWord() {
//    }
//}