package ru.otus.base;

import ru.otus.base.dataSets.UserDataSet;

import java.util.List;

/**
 * @author v.chibrikov
 */
public interface DBService {
    String getLocalStatus();

    UserDataSet read(long id);
    UserDataSet readByName(String name);
    List<UserDataSet> readAll();

    void save(UserDataSet dataSet);
    void shutdown();
}
