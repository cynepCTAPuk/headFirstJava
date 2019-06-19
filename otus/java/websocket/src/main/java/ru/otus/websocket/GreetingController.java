package ru.otus.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Random;

@Controller
public class GreetingController {
    Random random = new Random(42);
    int n = 5;
    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1_000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @MessageMapping("/spam")
    public void enableGarbageGenerator() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                garbage();
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(n + " random numbers");
            finalMessage();
        });
        thread.start();
    }

    public void garbage() {
        this.template.convertAndSend(
                "/topic/garbage", new Greeting("Random # " + random.nextInt()));
    }
    public void finalMessage() {
        this.template.convertAndSend(
                "/topic/garbage", new Greeting(n + " random numbers"));
    }
}
