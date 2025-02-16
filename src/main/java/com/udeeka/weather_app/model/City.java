package com.udeeka.weather_app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Getter
    @JsonProperty("CityCode")
    private String cityCode;

    @JsonProperty("CityName")
    private String cityName;

    @JsonProperty("Temp")
    private String temp;

    @JsonProperty("Status")
    private String status;

}
