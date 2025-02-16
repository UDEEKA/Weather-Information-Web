package com.udeeka.weather_app.service;

import com.udeeka.weather_app.config.ApiKeyConfig;
import com.udeeka.weather_app.dto.OpenWeatherResponse;
import com.udeeka.weather_app.model.WeatherInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    @Value("${openweathermap.api.url_full}")
    private String apiFullUrl;

    private final ApiKeyConfig apiKeyConfig;
    private final RestTemplate restTemplate = new RestTemplate();
    private final CityService cityService;

    public WeatherService(CityService cityService, ApiKeyConfig apiKeyConfig)
    {
        this.cityService = cityService;
        this.apiKeyConfig = apiKeyConfig;
    }

    @Cacheable(value = "weather", key = "'allCities'", unless = "#result == null")
    public List<WeatherInfo> getWeatherForAllCities() {

        List<String> cityIds = cityService.getCityIds();
        if (cityIds.isEmpty()) {
            throw new RuntimeException("No city IDs found");
        }

        String joinedCityIds = String.join(",", cityIds);
        String url = String.format(
                apiFullUrl,
                joinedCityIds, apiKeyConfig.getWeatherApiKey()
        );

        ResponseEntity<OpenWeatherResponse> response = restTemplate.getForEntity(url, OpenWeatherResponse.class);
        if (response.getBody() == null || response.getBody().getList() == null) {
            throw new RuntimeException("Failed to fetch weather data");
        }

        return response.getBody().getList().stream()
                .map(this::mapToWeatherInfo)
                .collect(Collectors.toList());
    }

    private WeatherInfo mapToWeatherInfo(OpenWeatherResponse.CityWeather cityWeather) {
        return new WeatherInfo(
                cityWeather.getCityCode(),
                cityWeather.getName(),
                cityWeather.getWeather().get(0).getDescription(),
                cityWeather.getMain().getTemp()
        );
    }
}
