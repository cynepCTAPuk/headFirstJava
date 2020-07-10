package com.example.ws;

import javax.jws.WebService;

// здесь используется с параметром endpointInterface, указывающим полное имя класса интерфейса нашего веб-сервиса
@WebService(endpointInterface = "com.example.ws.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {
    @Override
    public String getHelloString(String name) {
        // просто возвращаем приветствие
        return "Hello, " + name + "!";
    }
}