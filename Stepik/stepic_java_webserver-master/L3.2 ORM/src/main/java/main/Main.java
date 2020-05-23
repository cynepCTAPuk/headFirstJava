package main;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

import java.util.List;

/**
 * @author v.chibrikov<p>Пример кода для курса на https://stepic.org/<p>
 * Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        dbService.printConnectInfo();

        try {
            long userId = dbService.addUser("tully");
            System.out.println("Added user id: " + userId);
            dbService.addUser("CTAPuk");
            dbService.addUser("user");

            UsersDataSet dataSet = dbService.getUserById(userId);
            System.out.println("User data set: " + dataSet);

            long id = dbService.getUserIdByName("tully");
            System.out.println("Id for user tully: " + id);

            List<UsersDataSet> list = dbService.getAllRecords();
            System.out.println("Print all records: " + list);

//            dbService.closeSessionFactory();
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}
