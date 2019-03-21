package com.example;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class GuestBook {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String password = JOptionPane.showInputDialog(
                null, "Введите пароль:", "***");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", password);
        return connection;
    }

    public List<Post> getAllPosts() throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             ResultSet resultSet = c.createStatement().executeQuery(
                     "select * from posts")) {
            List<Post> posts = new ArrayList<>();
            while (resultSet.next()) {
                Post post = new Post();
                post.setPostID(resultSet.getInt("postID"));
                post.setPost(resultSet.getString("post"));
                posts.add(post);
            }
            return posts;
        }
    }

    public void addPost(Post p) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(
                     "insert into posts(postID, userID, post) value(?,?,?)")) {
            ps.setLong(1, p.getPostID());
            ps.setLong(2, p.getUserID());
            ps.setString(3, p.toString());
            ps.execute();
        }
    }
}
