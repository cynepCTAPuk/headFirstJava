package patterns.abstract_factory.level07lecture01;

public class ArmyOfPersons {
}

class HumanArmy extends Army {
    public Warrior createWarrior() {
        return new HumanWarrior();
    }

    public Archer createArcher() {
        return new HumanArcher();
    }

    public Mage createMag() {
        return new HumanMag();
    }
}

class ElfArmy extends Army {
    public Warrior createWarrior() {
        return new ElfWarrior();
    }

    public Archer createArcher() {
        return new ElfArcher();
    }

    public Mage createMag() {
        return new ElfMag();
    }
}

class DaemonArmy extends Army {
    public Warrior createWarrior() {
        return new DaemonWarrior();
    }

    public Archer createArcher() {
        return new DaemonArcher();
    }

    public Mage createMag() {
        return new DaemonMag();
    }
}