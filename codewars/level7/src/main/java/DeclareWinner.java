public class DeclareWinner {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter attack;
        Fighter defend;
        Fighter medium;
        if (firstAttacker == fighter1.name) {
            attack = fighter1;
            defend = fighter2;
        } else if (firstAttacker == fighter2.name) {
            attack = fighter2;
            defend = fighter1;
        } else {
            System.out.println("Check first attacker's name");
            throw new UnsupportedOperationException();
        }
        while (fighter1.health > 0 && fighter2.health > 0) {
            defend.health = defend.health - attack.damagePerAttack;
            medium = attack;
            attack = defend;
            defend = medium;
        }
        return defend.name;
    }
}

class Fighter {
    String name;
    int health;
    int damagePerAttack;

    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }
}