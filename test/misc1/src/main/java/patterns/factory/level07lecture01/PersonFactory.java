package patterns.factory.level07lecture01;

/**
 * https://javarush.ru/quests/lectures/questcollections.level07.lecture01
 */
public class PersonFactory {
    public static GamePerson createPerson(PersonType personType) throws GameException {
        switch (personType) {
            case MAG:
                return new Mage();
            case WARRIOR:
                return new Warrior();
            case TROLL:
                return new Troll();
            case ELV:
                return new Elf();
            default:
                throw new GameException();
        }
    }
}

