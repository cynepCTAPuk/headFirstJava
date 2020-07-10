package com.example.endpoint;

// класс, для запуска веб-сервера с веб-сервисами
import javax.xml.ws.Endpoint;
// класс нашего веб-сервиса
import com.example.ws.HelloWebServiceImpl;

public class HelloWebServicePublisher {
    public static void main(String... args) {
        // запускаем веб-сервер на порту 1986 и по адресу, указанному в первом аргументе,
        // запускаем веб-сервис, передаваемый во втором аргументе
//        Endpoint.publish("http://localhost:1986/wss/hello", new HelloWebServiceImpl());

        String address = "http://localhost:1986/wss/hello";
        Endpoint.publish(address, new HelloWebServiceImpl());
        System.out.println("WebService running: " + address + "?wsdl");
    }
}