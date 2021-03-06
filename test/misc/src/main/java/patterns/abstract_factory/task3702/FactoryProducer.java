package patterns.abstract_factory.task3702;

import patterns.abstract_factory.task3702.female.FemaleFactory;
import patterns.abstract_factory.task3702.male.MaleFactory;

public class FactoryProducer {
    public enum HumanFactoryType {
        FEMALE,
        MALE
    }

    public static AbstractFactory getFactory(HumanFactoryType humanFactoryType) {
        if(humanFactoryType == HumanFactoryType.FEMALE) return new FemaleFactory();
        else return new MaleFactory();
    }

}
