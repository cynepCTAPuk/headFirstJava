package com.example;

import javax.inject.Named;

@Named
public class ExampleBean {
    private String text = "CDI Example";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
