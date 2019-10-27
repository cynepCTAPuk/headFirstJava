package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

    @GetMapping("/app")
    @ResponseBody
    public String getGreeting() {
        return "Hello world.";
    }
}