package com.example.stiraralka_bot.responseSenders;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component("порно")
public class RandomPornoSender implements Sender{
    @Override
    public String sendResponse() {
        HttpURLConnection connection = null;
        StringBuilder response = new StringBuilder();
        try {
            //Create connection
            URL url;

            url = new URL("https://rt.pornhub.com/video/random");

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
        return "расчехляйся -> "+ response.substring(response.indexOf("href=\"")+6, response.indexOf("\" />"));
    }
}
