package patterns.mvc.task3601;

import java.util.List;

public class Model {
    public List<String> getStringDataList() {
        return new Service().getData();
    }
}
