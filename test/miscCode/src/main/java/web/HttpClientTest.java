package web;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Stream;

public class HttpClientTest {
    public static void main(String[] args)
            throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder(new URI("https://minijug.ru"))
                .build();

        HttpResponse<Stream<String>> response = client.send(request,
                HttpResponse.BodyHandlers.ofLines());

        System.out.println("Status code = " + response.statusCode());
        System.out.println("Body = ");
//        response.body().limit(4).forEach(System.out::println); // Первые 4 строки
        response.body().forEach(System.out::println); // Первые 4 строки
    }
}
