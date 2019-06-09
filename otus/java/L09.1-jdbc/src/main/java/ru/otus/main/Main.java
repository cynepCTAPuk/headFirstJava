package ru.otus.main;

import ru.otus.base.DBService;
import ru.otus.base.UsersDataSet;
import ru.otus.connection.DBServiceConnection;
import ru.otus.connection.DBServiceUpdate;
import ru.otus.logger.DBServiceLog;
import ru.otus.prepared.DBServicePrepared;
import ru.otus.simple.DBServiceSimple;
import ru.otus.transaction.DBServicePreparedTransactional;

import java.util.List;

/**
 * mysql> CREATE USER 'tully'@'localhost' IDENTIFIED BY 'tully';
 * mysql> GRANT ALL PRIVILEGES ON * . * TO 'tully'@'localhost';
 * mysql> select user, host from mysql.user;
 * mysql> create database db_example;
 * mysql> SET GLOBAL time_zone = '+3:00';
 */

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private void run() throws Exception {
//        try(DBService dbService = new DBServiceConnection()) {
//        try (DBService dbService = new DBServiceUpdate()) {
//        try (DBService dbService = new DBServiceLog()) {
        try (DBService dbService = new DBServiceSimple()) {
//        try (DBService dbService = new DBServicePrepared()) {
//        try (DBService dbService = new DBServicePreparedTransactional()) {
            System.out.println("-1 " + dbService.getMetaData());                             // 1
            dbService.prepareTables();
            dbService.addUsers("tully", "sully");
            System.out.println("-2 UserName with id = 2: " + dbService.getUserName(2));  // 2
            List<String> names = dbService.getAllNames();
            System.out.println("-3 All names: " + names.toString());                         // 3
            List<UsersDataSet> users = dbService.getAllUsers();
            System.out.println("-4 All users: " + users.toString());                         // 4
            dbService.deleteTables();
        }
    }
}
