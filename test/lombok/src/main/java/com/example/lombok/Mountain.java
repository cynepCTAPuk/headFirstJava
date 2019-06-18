package com.example.lombok;

import lombok.Data;

public @Data class Mountain {
    private final String name;
    private final double latitude, longitude;
    private String country;
}
