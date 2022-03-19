package org.example;

import org.springframework.stereotype.Component;

@Component
public class ClassicMusic implements Music {
    @Override
    public String getSong() {
        return "Classic";
    }
}
