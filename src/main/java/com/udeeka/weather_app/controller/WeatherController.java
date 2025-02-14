package com.udeeka.weather_app.controller;

import com.udeeka.weather_app.model.WeatherInfo;
import com.udeeka.weather_app.service.CityService;
import com.udeeka.weather_app.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;
    private final CityService cityService;

    public WeatherController(WeatherService weatherService, CityService cityService) {
        this.weatherService = weatherService;
        this.cityService = cityService;
    }

    @GetMapping("/city-ids")
    public List<String> getCityIds() {
        return cityService.getCityIds();
    }

    @GetMapping("/{cityId}")
    public WeatherInfo getWeather(@PathVariable String cityId) {
        return weatherService.getWeatherInfo(cityId);
    }
}
