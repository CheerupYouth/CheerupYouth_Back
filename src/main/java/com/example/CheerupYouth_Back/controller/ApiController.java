package com.example.CheerupYouth_Back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class ApiController {
    @GetMapping("/api")
    public String callApi() throws IOException {
        StringBuilder result = new StringBuilder();

        String apiUrl = "https://api.odcloud.kr/api/15038446/v1/tn_pubr_public_fshlc?" +
                "serviceKey=X7AtWuN8FDgHQhAPppOzcw1UByZMYNWZRKL1WuS2LW34drsWnhXDPZvt035gMrZvC1c4MBdAXlYnO%2FVR%2BC5qsg%3D%3D" +
                "&pageNo=1" +
                "&numOfRows=10" +
                "&returnType=JSON";

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
        } else {
            result.append("API 호출 실패, 응답코드: ").append(responseCode);
        }

        connection.disconnect();

        return result.toString();
    }
}
