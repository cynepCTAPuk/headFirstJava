package aggregator.task2810.view;

import aggregator.task2810.Controller;
import aggregator.task2810.vo.Vacancy;

import java.util.List;

public interface View {
    void update(List<Vacancy> vacancies);
    void setController(Controller controller);
}
