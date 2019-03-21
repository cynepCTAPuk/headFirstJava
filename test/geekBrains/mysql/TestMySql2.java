package mysql;

import javax.swing.*;
import java.sql.*;

public class TestMySql2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String password = JOptionPane.showInputDialog(
                null, "Введите пароль:", "***");
        String insert = "insert into users(name,age) values(?,?)";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", password);
        PreparedStatement ps = conn.prepareStatement(insert);

        ps.setString(1, "TestUser");
        ps.setInt(2, 1);
        ps.execute();

        ps.closeOnCompletion();
        conn.close();
    }
}
