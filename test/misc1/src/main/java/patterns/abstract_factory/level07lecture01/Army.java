package patterns.abstract_factory.level07lecture01;

abstract class Army {
    abstract Warrior createWarrior();

    abstract Archer createArcher();

    abstract Mage createMag();
}
