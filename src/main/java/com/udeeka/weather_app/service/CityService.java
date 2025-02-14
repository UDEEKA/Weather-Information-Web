package com.udeeka.weather_app.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Data
@Service
public class CityService {
    private final List<String> cityIds = new ArrayList<>();

    public CityService() {
        loadCityIds();
    }

    private void loadCityIds() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(new File("src/main/resources/cities.json"));
            JsonNode citiesList = root.get("List");

            if (citiesList != null && citiesList.isArray()) {
                for (JsonNode city : citiesList) {
                    cityIds.add(city.get("CityCode").asText());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<String> getCityIds() {
        return cityIds;
    }

}
