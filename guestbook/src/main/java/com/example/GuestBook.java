package com.example;

import java.sql.*;
import java.util.*;

public class GuestBook {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.next();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", password);
        return connection;
    }

    public static List<Post> getAllPosts() throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        ResultSet resultSet = c.createStatement().executeQuery(
                "select * from posts");
        ArrayList<Post> posts = new ArrayList<>();
        while (resultSet.next()) {
            Post post = new Post();
            post.setPostID(resultSet.getLong("postID"));
            post.setUserID(resultSet.getLong("userID"));
            post.setPost(resultSet.getString("post"));
            posts.add(post);
        }
        return posts;
    }

    public static void addPost(Post p) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement(
                "insert into posts(postID, userID, post) value(?,?,?)");
        ps.setLong(1, p.getPostID());
        ps.setLong(2, p.getUserID());
        ps.setString(3, p.toString());
        ps.execute();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getAllPosts());
    }
}

