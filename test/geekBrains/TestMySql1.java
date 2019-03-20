import java.sql.*;
import java.util.*;

public class TestMySql1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.next();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", password);
        Statement statement = conn.createStatement();
        statement.executeUpdate("insert into users(name,age) values('Steve',15)");
//        statement.executeUpdate("delete from users where name='Steve'");
        conn.close();
    }
}
