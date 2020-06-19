package com.example.wheatherapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Weather {
    private String source;
    private String city;
    private String temperature;

}
