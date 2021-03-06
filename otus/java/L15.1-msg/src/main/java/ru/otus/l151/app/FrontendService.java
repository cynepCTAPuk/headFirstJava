package ru.otus.l151.app;

import ru.otus.l151.messageSystem.Addressee;

public interface FrontendService extends Addressee {
    void init();
    void handleRequest(String login);
    void addUser(int id, String name);
}

