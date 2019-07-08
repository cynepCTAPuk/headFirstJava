package ru.otus.l151.app;

import ru.otus.l151.messageSystem.Addressee;

public interface DBService extends Addressee {
    void init();
    int getUserId(String name);
}
