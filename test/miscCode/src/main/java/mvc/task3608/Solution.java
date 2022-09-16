package mvc.task3608;

import mvc.task3608.controller.Controller;
import mvc.task3608.model.MainModel;
import mvc.task3608.model.Model;
import mvc.task3608.view.EditUserView;
import mvc.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        editUserView.fireEventOpenUserEditForm(126);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Smirnov",126,5);
        usersView.fireEventShowDeletedUsers();

    }
}