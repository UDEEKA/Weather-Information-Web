package com.udeeka.weather_app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResponse {

    @JsonProperty("list")
    private List<CityWeather> list;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CityWeather {
        @JsonProperty("id")
        private Long cityCode;
        private String name;
        private List<Weather> weather;
        private Main main;
    }

    @Data
    public static class Weather {
        private String description;
    }

    @Data
    public static class Main {
        @JsonProperty("temp")
        private double temp;
    }
}