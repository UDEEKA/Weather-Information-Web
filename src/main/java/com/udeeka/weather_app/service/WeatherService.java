package com.udeeka.weather_app.service;

import com.udeeka.weather_app.dto.OpenWeatherResponse;
import com.udeeka.weather_app.exception.CityNotFoundException;
import com.udeeka.weather_app.model.WeatherInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherInfo getWeatherInfo(String cityId) {
        String url = String.format(
                "http://api.openweathermap.org/data/2.5/weather?id=%s&units=metric&appid=%s",
                cityId, apiKey
        );

        try {
            ResponseEntity<OpenWeatherResponse> response = restTemplate.getForEntity(url, OpenWeatherResponse.class);

            if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
                throw new CityNotFoundException("City not found for ID: " + cityId);
            }

            OpenWeatherResponse responseBody = response.getBody();
            return mapToWeatherInfo(responseBody);

        } catch (HttpClientErrorException.NotFound e) {
            throw new CityNotFoundException("City not found for ID: " + cityId);
        }
    }

    private WeatherInfo mapToWeatherInfo(OpenWeatherResponse response) {
        if (response == null || response.getWeather() == null || response.getWeather().isEmpty()) {
            throw new RuntimeException("Invalid API response");
        }

        return new WeatherInfo(
                response.getName(),
                response.getWeather().get(0).getDescription(),
                response.getMain().getTemp()
        );
    }
}
