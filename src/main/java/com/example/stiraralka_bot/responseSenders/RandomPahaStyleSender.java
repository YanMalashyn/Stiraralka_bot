package com.example.stiraralka_bot.responseSenders;

import org.springframework.stereotype.Component;

@Component("паха")
public class RandomPahaStyleSender implements Sender{
    @Override
    public String sendResponse() {
        int b = RandomPahaStyleSender.pachyPhrases.values().length-1;
        long result = Math.round(Math.random()*b);
        return RandomPahaStyleSender.pachyPhrases.values()[(int)result].getS();
    }

    private enum pachyPhrases{
        one("Ебать ту Люсю"), two("хвост-чешуя"), three("бойлер работает"), foth("без пизды"), five("а шо ты?"),
        six("до центра 5к"), seven("канистру не забудь"), eight("пацаны, простите"), nine("да бля, тут нечего ловить"),
        ten("в финку погоню"), eleven("копеечку свою имею"), twelve("звони, перетрём"),
        one1("да пздц, что-то все потерялись"), one2("бочка круглая"), one3("Стас, не еби головы"),
        one4("да я и сам в ахуе с цен"), one5("пивка да в баньку"), one6("саня сам виноват"),
        one7("Серый, женился уже?"), one8("Золотая фраза, ебать тебе повезло");

        public String getS() {
            return s;
        }

        private String s;
        pachyPhrases(String s){
            this.s = s;
        }
    }
}
