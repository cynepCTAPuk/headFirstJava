package mvc.task3608.view;

import mvc.task3608.controller.Controller;
import mvc.task3608.model.ModelData;

public interface View {
    void refresh(ModelData modelData);

    void setController(Controller controller);
}
