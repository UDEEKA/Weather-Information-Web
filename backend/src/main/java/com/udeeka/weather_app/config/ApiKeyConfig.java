package com.udeeka.weather_app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyConfig {

@Value("#{weatherApiKey}")
String weatherApiKey;

    public String getWeatherApiKey() {
        return weatherApiKey;
    }
}
