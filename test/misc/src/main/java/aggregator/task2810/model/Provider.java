package aggregator.task2810.model;


import aggregator.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchString){
        if (strategy == null) return new ArrayList<>();
        return strategy.getVacancies(searchString);
    }
}
