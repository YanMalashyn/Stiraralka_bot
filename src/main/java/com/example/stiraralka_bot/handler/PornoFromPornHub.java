package com.example.stiraralka_bot.handler;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PornoFromPornHub implements AbstractBotAbility{

    @Override
    public String getResponse(String s, String name) {
        List<String> collect = s.lines().flatMap(x -> Arrays.stream(x.split(" "))).collect(Collectors.toList());
        if(collect.stream().anyMatch(x -> x.equalsIgnoreCase("порно"))){
            return randomPorno(name);
        }
        return "";
    }

    private String randomPorno(String name) {
        HttpURLConnection connection = null;
        StringBuilder response = new StringBuilder();
        try {
            //Create connection
            URL url;
            System.out.println(name);
            if(name.equals("Stanislau14")){
                url = new URL("https://rt.pornhub.com/gay/video/random");
            }else {
                url = new URL("https://rt.pornhub.com/video/random");
            }
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");


            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
             // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                if(line.contains("viewkey")){
                    response.append(line);
                }
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return response.substring(response.indexOf("href=\"")+6, response.indexOf("\" />"));


    }

}


