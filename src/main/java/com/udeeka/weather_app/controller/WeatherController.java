package com.udeeka.weather_app.controller;

import com.udeeka.weather_app.model.WeatherInfo;
import com.udeeka.weather_app.service.WeatherService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // Allow frontend requests
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_USER')") // Only users with ROLE_USER can access
    public List<WeatherInfo> getAllWeatherData() {
        return weatherService.getWeatherForAllCities();
    }
}
