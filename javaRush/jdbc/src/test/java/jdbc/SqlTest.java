/**
 * https://javarush.ru/groups/posts/2172-jdbc-ili-s-chego-vsje-nachinaetsja
 */
package jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SqlTest {
    private static Connection connection;

    private Connection getNewConnection() throws SQLException {
//        String url = "jdbc:h2:file:C:/0/test";
        String url = "jdbc:h2:mem:test";
//        String url = "jdbc:h2:~/test";
        String user = "sa";
        String passwd = "sa";
        return DriverManager.getConnection(url, user, passwd);
    }

    private int executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        // Для Insert, Update, Delete
        int result = statement.executeUpdate(query);
        return result;
    }

    private void createCustomerTable() throws SQLException {
        String customerTableQuery = "CREATE TABLE customers (id INTEGER PRIMARY KEY, name TEXT, age INTEGER)";
        executeUpdate(customerTableQuery);
        String customerEntryQuery = "INSERT INTO customers VALUES (1, 'Brian', 23)";
        executeUpdate(customerEntryQuery);
        customerEntryQuery = "INSERT INTO customers VALUES (2, 'Elena', 33)";
        executeUpdate(customerEntryQuery);
        customerEntryQuery = "INSERT INTO customers VALUES (3, 'CTAPuk', 43)";
        executeUpdate(customerEntryQuery);
    }

    private DataSource getDatasource() {
        HikariConfig config = new HikariConfig();
        config.setUsername("sa");
        config.setPassword("sa");
        config.setJdbcUrl("jdbc:h2:mem:test");
        DataSource ds = new HikariDataSource(config);
        return ds;
    }

    public void showAllDataFromCustomers() throws SQLException {
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
    }

    @Test
    public void shouldCommitTransaction() throws SQLException {
        createCustomerTable(); // create & fill table CUSTOMERS

        connection.setAutoCommit(false);
        String query = "INSERT INTO customers VALUES (101, 'Max', 20)";
        connection.createStatement().executeUpdate(query);
        connection.commit();
        Statement statement = connection.createStatement();
        statement.execute("SELECT * FROM customers");
        ResultSet resultSet = statement.getResultSet();
        int count = 0;
        while (resultSet.next()) count++;
        assertEquals(4, count);

        showAllDataFromCustomers(); // show table CUSTOMERS
    }

    @Test
    public void shouldGetConnectionFromDataSource() throws SQLException {
        // required next libs
        //  implementation 'com.zaxxer:HikariCP:3.4.1'
        //  implementation 'org.slf4j:slf4j-api:1.7.2'
        //  implementation 'org.slf4j:slf4j-simple:1.7.2'
        DataSource datasource = getDatasource();
        try (Connection con = datasource.getConnection()) {
            assertTrue(con.isValid(1));
        }
    }

    @Test
    public void shouldGetJdbcConnection() throws SQLException {
        try (Connection connection = getNewConnection()) {
            assertTrue(connection.isValid(1));
            assertFalse(connection.isClosed());
        }
    }

    @Test
    public void shouldCreateCustomerTable() throws SQLException {
        createCustomerTable();
        showAllDataFromCustomers();
//        connection.createStatement().execute("SELECT * FROM customers");
    }

    @Test
    public void shouldSelectOneRecord() throws SQLException {
        createCustomerTable();
        String query = "SELECT * FROM customers WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "Brian");
        boolean hasResult = statement.execute();
        assertTrue(hasResult);
        // Обработаем результат
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        int age = resultSet.getInt("age");
        assertEquals(23, age);
    }

    @Test
    public void shouldInsertOneRecord() throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
        resultSet.moveToInsertRow();
        resultSet.updateLong("id", 1L);
        resultSet.updateString("name", "DeadMoroz");
        resultSet.updateInt("age", 99);
        resultSet.insertRow();
        resultSet.moveToCurrentRow();
    }

    @Test
    public void shouldGetMetadata() throws SQLException {
        createCustomerTable();
        // У нас URL = "jdbc:h2:mem:test", где test - название БД
        // Название БД = catalog
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet result = metaData.getTables
                ("TEST", "PUBLIC", "%", null);
        List<String> tables = new ArrayList<>();
        while (result.next())
            tables.add(result.getString(2) + "." + result.getString(3));
        System.out.println(tables);
        assertTrue(tables.contains("PUBLIC.CUSTOMERS"));
        showAllDataFromCustomers();
    }

    @Before
    public void init() throws SQLException {
        connection = getNewConnection();
    }

    @After
    public void close() throws SQLException {
        connection.close();
    }
}
