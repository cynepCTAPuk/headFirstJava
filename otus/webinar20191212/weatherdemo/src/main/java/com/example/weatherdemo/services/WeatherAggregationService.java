package com.example.weatherdemo.services;

import com.example.weatherdemo.model.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class WeatherAggregationService implements WeatherService {

    private final List<WeatherService> weatherServices;

    @Override
    public List<Weather> gWeather() {
        List<Weather> weatherList = new ArrayList<>();
        weatherServices.forEach(ws -> weatherList.addAll(ws.gWeather()));
        return weatherList;
    }
}
