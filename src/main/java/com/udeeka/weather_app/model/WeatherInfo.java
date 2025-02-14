package com.udeeka.weather_app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfo {
    private String cityName;
    private String weatherCondition;
    private double temperature;

    public WeatherInfo(String cityName, String weatherCondition, double temperature) {
        this.cityName = cityName;
        this.weatherCondition = weatherCondition;
        this.temperature = temperature;
    }

}
