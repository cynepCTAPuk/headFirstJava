package patterns.task3702.female;

import patterns.task3702.AbstractFactory;
import patterns.task3702.Human;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age) {
        if (age <= 12) return new KidGirl();
        else if (age <= 19) return new TeenGirl();
        else return new Woman();
    }
}
