import java.sql.*;

public class TestMySql0 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String password = "";

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root", password);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select 1+1");
        while (resultSet.next()) System.out.println(resultSet.getInt(1));
        resultSet.close();
        conn.close();
    }
}
