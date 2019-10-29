package reflection;

public class User {
    public int userID;
    public String name;
    public String email;
    public String password;
    public boolean isAdmin;

    public User() {
    }

    public User(int userID, String name, String email) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        password = "";
        isAdmin = false;
    }

    public User(int userID, String name, String email, String password, boolean isAdmin) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
