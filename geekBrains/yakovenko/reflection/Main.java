package reflection;

import javax.swing.JOptionPane;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String password = JOptionPane.showInputDialog(
            null, "Введите пароль:", "********");

    public static Connection getGonnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", password);
    }

    public static void getUsers() {
        try (Connection c = getGonnection();
             PreparedStatement ps = c.prepareStatement("select * from users");
             ResultSet resultSet = ps.executeQuery()) {
            ArrayList<User> users = new ArrayList<>();
            while (resultSet.next()) {
                int userID = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String password = resultSet.getString(4);
                boolean isAdmin = resultSet.getBoolean(5);
                users.add(new User(userID, name, email, password, isAdmin));
            }
            for (User u : users) System.out.println(u);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getPosts() {
        try (Connection c = getGonnection();
             PreparedStatement ps = c.prepareStatement("select * from posts");
             ResultSet resultSet = ps.executeQuery()) {
            ArrayList<Post> posts = new ArrayList<>();
            while (resultSet.next()) {
                int postID = resultSet.getInt(1);
                int userID = resultSet.getInt(2);
                String post = resultSet.getString(3);
                posts.add(new Post(postID, userID, post));
            }
            for (Post p : posts) System.out.println(p);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void populateBean(Object o, ResultSet rs) {
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getFields();
        try {
            if (!rs.next()) return;
            for (Field f : fields) {
                String name = f.getName();
                if (f.getType().equals(String.class)) {
                    String val = rs.getString(name);
                    f.set(o, val);
                } else if (f.getType().equals(Integer.class) || f.getType().equals(int.class)) {
                    Integer val = rs.getInt(name);
                    f.set(o, val);
                } else if (f.getType().equals(Boolean.class) || f.getType().equals(boolean.class)) {
                    Boolean val = rs.getBoolean(name);
                    f.set(o, val);
                }
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("deprecation")
    public static List selectAll(Class clazz, ResultSet rs) {
        ArrayList arrayList = new ArrayList();
        Field[] fields = clazz.getFields();

        try {
            while (rs.next()) {
                Object o = clazz.newInstance();
                arrayList.add(o);
                for (Field f : fields) {
                    String name = f.getName();
                    if (f.getType().equals(String.class)) {
                        String val = rs.getString(name);
                        f.set(o, val);
                    } else if (f.getType().equals(Integer.class)
                            || f.getType().equals(int.class)) {
                        Integer val = rs.getInt(name);
                        f.set(o, val);
                    } else if (f.getType().equals(Boolean.class)
                            || f.getType().equals(boolean.class)) {
                        Boolean val = rs.getBoolean(name);
                        f.set(o, val);
                    }
                }
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
//        getUsers();
//        getPosts();
        User u = new User();
        Post p = new Post();
/*
        try (Connection c = getGonnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT * FROM users LIMIT 1")) {
                try (ResultSet resultSet = ps.executeQuery()) {
                    populateBean(u, resultSet);
                    System.out.println(u);
                }
            }
        }
*/
/*
        try (Connection c = getGonnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT * FROM posts LIMIT 1")) {
                try (ResultSet resultSet = ps.executeQuery()) {
                    populateBean(p, resultSet);
                    System.out.println(p);
                }
            }
        }
*/
/*
        try (Connection c = getGonnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT * FROM users")) {
                try (ResultSet resultSet = ps.executeQuery()) {
                    List list = selectAll(User.class, resultSet);
                    for (Object o : list) System.out.println(o);
                }
            }
        }
*/
/*
        try (Connection c = getGonnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT * FROM posts")) {
                try (ResultSet resultSet = ps.executeQuery()) {
                    List list = selectAll(Post.class, resultSet);
                    for (Object o : list) System.out.println(o);
                }
            }
        }
*/
        String request =
                "SELECT users.name, posts.post FROM posts, users WHERE users.userID=posts.userID;";
        try (Connection c = getGonnection()) {
            try (PreparedStatement ps = c.prepareStatement(request)) {
                try (ResultSet resultSet = ps.executeQuery()) {
                    List list = selectAll(Object.class, resultSet);
                    for (Object o : list) System.out.println(o);
                }
            }
        }
    }

/*
        Integer x = 4;
        Class claz = x.getClass();
        for (Object o : claz.getMethods()) System.out.println(o);
        for (Object o : claz.getFields()) System.out.println(o);
*/
}

