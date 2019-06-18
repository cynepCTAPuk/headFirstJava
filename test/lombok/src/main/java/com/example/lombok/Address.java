package com.example.lombok;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Address {
    String city;
    String street;
    String building;
}
