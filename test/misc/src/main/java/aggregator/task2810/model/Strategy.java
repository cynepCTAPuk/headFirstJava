package aggregator.task2810.model;

import aggregator.task2810.vo.Vacancy;

import java.util.List;

public interface Strategy {
    List<Vacancy> getVacancies(String searchString);
}
