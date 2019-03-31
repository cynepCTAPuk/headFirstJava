package ru.otus;

public class Server implements ServerMBean {
    private String message;

    public Server(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
