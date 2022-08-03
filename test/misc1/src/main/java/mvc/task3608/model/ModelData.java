package mvc.task3608.model;

import mvc.task3608.bean.User;

import java.util.List;

public class ModelData {
    private User activeUser;
    private List<User> users;
    private boolean displayDeletedUserList;

    public User getActiveUser() {
        return activeUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }
}
