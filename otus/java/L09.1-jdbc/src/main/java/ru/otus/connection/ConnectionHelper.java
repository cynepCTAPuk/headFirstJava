package ru.otus.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

class ConnectionHelper {

    static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            System.out.print("Enter user: ");
            String user = new Scanner(System.in).next();
            System.out.print("Enter password: ");
            String password = new Scanner(System.in).next();

            String url = "jdbc:mysql://" +          //db type
                    "localhost:" +                  //host name
                    "3306/" +                       //port
                    "db_example?" +                 //db name
//                    "user=tully&" +                 //login
                    "user=" + user + "&" +          //login
//                    "password=tully&" +             //password
                    "password=" + password + "&" +  //password
                    "useSSL=false";                 //do not use Secure Sockets Layer

            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
