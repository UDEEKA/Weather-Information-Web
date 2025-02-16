package com.udeeka.weather_app.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {
    private static final Dotenv dotenv = Dotenv.load();

    @Bean
    public static String weatherApiKey() {
        return dotenv.get("WEATHER_API_KEY");
    }
}