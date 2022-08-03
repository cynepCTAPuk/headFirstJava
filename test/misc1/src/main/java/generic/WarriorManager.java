package generic;

import java.util.ArrayList;
import java.util.List;

public class WarriorManager {
    public static void main(String[] args) {
        MagicWarrior mag = new MagicWarrior();
        ArcherWarrior archer = new ArcherWarrior();
        boolean isMagicCooler = WarriorManager.fight(mag, archer);
        System.out.println(isMagicCooler);

        ArrayList<MagicWarrior> magi = new ArrayList<>();
        for (int i = 0; i < 10; i++) magi.add(new MagicWarrior());

        ArrayList<ArcherWarrior> archers = new ArrayList<>();
        for (int i = 0; i < 19; i++) archers.add(new ArcherWarrior());

        isMagicCooler = WarriorManager.fight(magi, archers);
        System.out.println(isMagicCooler);
    }

    public static boolean fight(Warrior w1, Warrior w2) {
        return w1.power > w2.power;
    }

    public static boolean fight(List<? extends Warrior> w1, List<? extends Warrior> w2) {
        int w1Power = 0;
        for (Warrior w : w1) w1Power += w.power;
        int w2Power = 0;
        for (Warrior w : w2) w2Power += w.power;
        return w1Power > w2Power;
    }


}

class Warrior {
    public int power;
}

class MagicWarrior extends Warrior {
    public MagicWarrior() {
        power = 20;
    }
}

class ArcherWarrior extends Warrior {
    public ArcherWarrior() {
        power = 10;
    }
}