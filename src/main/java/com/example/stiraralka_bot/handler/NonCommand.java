package com.example.stiraralka_bot.handler;


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
                .flatMap(x -> Arrays.stream(x.split("\\?")))
                .flatMap(x -> Arrays.stream(x.split("\\.")))
                .filter(x -> x.equalsIgnoreCase("паха") || x.equalsIgnoreCase("пахе") ||
                        x.equalsIgnoreCase("пахой") || x.equalsIgnoreCase("паху")
                || x.equalsIgnoreCase("пахи"))
                .count();
        if(count > 0) {
            int b = pachyPhrases.values().length-1;
            long result = Math.round(Math.random()*b);
            return pachyPhrases.values()[(int)result].getS();
        }
        return "";
    }

    enum pachyPhrases{
        one("Ебать ту Люсю"), two("хвост-чешуя"), three("бойлер работает"), foth("без пизды"), five("а шо ты?"),
        six("до центра 5к"), seven("канистру не забудь"), eight("пацаны, простите"), nine("да бля, тут нечего ловить"),
        ten("в финку погоню"), eleven("копеечку свою имею"), twelve("звони, перетрём"),
        one1("да пздц, что-то все потерялись"), one2("бочка круглая"), one3("Стас, не еби головы"),
        one4("да я и сам в ахуе с цен"), one5("пивка да в баньку"), one6("саня сам виноват"),
        one7("Серый, женился уже?");

        public String getS() {
            return s;
        }

        private String s;
        pachyPhrases(String s){
            this.s = s;
        }
    }

}


