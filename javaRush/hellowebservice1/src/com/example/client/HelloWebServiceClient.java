package com.example.client;


import com.example.ws.*; // подключаем классы-заглушки

public class HelloWebServiceClient {
    public static void main(String[] args) {
        // подключаемся к тегу service в wsdl описании
        HelloWebServiceImplService helloService = new HelloWebServiceImplService();

        // получив информацию из тега service подключаемся к самому веб-сервису
        HelloWebService hello = helloService.getHelloWebServiceImplPort();

        // обращаемся к веб-сервису и выводим результат в консоль
        System.out.println(hello.getHelloString("JavaRush Community"));
    }
}