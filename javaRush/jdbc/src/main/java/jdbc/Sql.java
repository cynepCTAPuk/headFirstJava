package jdbc;

import java.sql.*;

public class Sql {
    public static void main(String[] args) throws SQLException {
        Sql sql = new Sql();
//        sql.createNewRecord();
//        sql.createNewRecord();
//        sql.deleteOneRecord(1);
        sql.selectAllData();
//        sql.selectOneRecord();
    }

    private static Connection connection;

    private Connection getNewConnection() throws SQLException {
        String url = "jdbc:h2:file:C:/0/test";
//        String url = "jdbc:h2:mem:test";
//        String url = "jdbc:h2:~/test";
        String user = "sa";
        String passwd = "sa";
        return DriverManager.getConnection(url, user, passwd);
    }

    private int executeUpdate(String query) throws SQLException {
        init();
        Statement statement = connection.createStatement();
        // Для Insert, Update, Delete
        int result = statement.executeUpdate(query);
        System.out.println("statement.executeUpdate(query): " + result);
        close();
        return result;
    }

    private void createNewRecord() throws SQLException {
//        String customerEntryQuery = "INSERT INTO customers VALUES (73, 'Brian', 33)";
        String customerEntryQuery = "INSERT INTO customers VALUES (76, 'CTAPuk', 25)";
//        String customerEntryQuery = "INSERT INTO customers VALUES (78, 'Lena', 19)";
        executeUpdate(customerEntryQuery);
    }

    private void deleteOneRecord(int id) throws SQLException {
        init();
//        String query = "DELETE FROM customers WHERE name = 'CTAPuk'";
        String query = "DELETE FROM customers WHERE id = " + id;
        executeUpdate(query);
        close();
    }

    public void selectAllData() throws SQLException {
        init();

        String query = "SELECT * FROM customers";
        PreparedStatement statement = connection.prepareStatement(query);
        boolean hasResult = statement.execute();

        // Обработаем результат
        ResultSet resultSet = statement.getResultSet();
        System.out.println(resultSet.getStatement());

        String format = "%3s %3s %10s %3s\n";
        System.out.printf(format, "row", "id", "name", "age");
        while (resultSet.next()) {
            int row = resultSet.getRow();
            int id = resultSet.getInt("id");
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            System.out.printf(format, row, id, name, age);
        }

        close();
    }

    public void selectOneRecord() throws SQLException {
        init();

        String query = "SELECT * FROM customers WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "Brian");
        boolean hasResult = statement.execute();

        // Обработаем результат
        ResultSet resultSet = statement.getResultSet();
        System.out.println(resultSet.getStatement());

        String format = "%3s %3s %10s %3s\n";
        System.out.printf(format, "row", "id", "name", "age");
        while (!resultSet.isLast()) {
            resultSet.next();
            int row = resultSet.getRow();
            int id = resultSet.getInt("id");
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            System.out.printf(format, row, id, name, age);
        }

        close();
    }

    public void init() throws SQLException {
        connection = getNewConnection();
    }

    public void close() throws SQLException {
        connection.close();
    }

    private void createCustomerTable() throws SQLException {
        init();
        String customerTableQuery = "CREATE TABLE customers (id INTEGER PRIMARY KEY, name TEXT, age INTEGER)";
        executeUpdate(customerTableQuery);
        close();
    }

}
