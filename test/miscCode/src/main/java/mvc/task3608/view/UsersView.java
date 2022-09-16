package mvc.task3608.view;

import mvc.task3608.bean.User;
import mvc.task3608.controller.Controller;
import mvc.task3608.model.ModelData;

public class UsersView implements View {
    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList()) System.out.println("All deleted users:");
        else System.out.println("All users:");
        for (User user : modelData.getUsers()) System.out.println("\t" + user);
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
}
