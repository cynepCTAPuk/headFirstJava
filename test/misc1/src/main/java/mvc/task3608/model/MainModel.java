package mvc.task3608.model;

import mvc.task3608.bean.User;
import mvc.task3608.model.service.UserService;
import mvc.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    private List<User> getAllUsers() {
        List<User> users = userService.getUsersBetweenLevels(1, 100);
        return userService.filterOnlyActiveUsers(users);
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
//        List<User> users = userService.getUsersBetweenLevels(1, 100);
//        modelData.setUsers(users);
        modelData.setUsers(getAllUsers());
    }

    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }


    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setUsers(getAllUsers());
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long id) {
        User user = userService.deleteUser(id);
        modelData.setUsers(getAllUsers());
        modelData.setActiveUser(user);
    }

    public void changeUserData(String name, long id, int level) {
        User user = userService.createOrUpdateUser(name, id, level);
        modelData.setUsers(getAllUsers());
        modelData.setActiveUser(user);
    }
}
