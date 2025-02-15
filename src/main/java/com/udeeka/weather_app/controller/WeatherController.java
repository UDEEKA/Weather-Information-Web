package com.udeeka.weather_app.controller;

import com.udeeka.weather_app.model.WeatherInfo;
import com.udeeka.weather_app.service.CityService;
import com.udeeka.weather_app.service.WeatherService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/all")
    @PreAuthorize("isAuthenticated()")
    public List<WeatherInfo> getAllWeatherData() {
        return weatherService.getWeatherForAllCities();
    }
}
