package chap04_Objects_Classes;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class UsersHttpClient {
    public static void main(String[] args) throws Exception {
        var client = HttpClient.newBuilder().build();
        var request = HttpRequest.newBuilder()
                .GET()
//                .uri(URI.create("https://reqres.in/api/users?page=2"))
                .uri(URI.create("https://time.com"))
                .build();
        var response = client.send(request, BodyHandlers.ofString());

//        if(response.statusCode())

        System.out.printf("Response code is: %d %n", response.statusCode());
//        String[] bodyR = response.body().split("\\{");
//        for(String s:bodyR) System.out.println(s);
        System.out.printf("The response body is:%n %s %n", response.body());
    }
}