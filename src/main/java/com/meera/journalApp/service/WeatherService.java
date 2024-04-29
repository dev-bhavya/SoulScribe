package com.meera.journalApp.service;

import com.meera.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    // https://api.weatherapi.com/v1/current.json?key=<API_KEY>&q=<USER_CITY>

//    @Value("${myapi.api-key}")
    private String apiKey = "enter-key";
    private static final String API = "https://api.weatherapi.com/v1/current.json?key=API_KEY&q=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        String finalAPI = API.replace("API_KEY",apiKey).replace("CITY",city);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        return response.getBody();
    }
}



