package patterns.bridge.level07lecture02;

/**
 * https://javarush.ru/quests/lectures/questcollections.level07.lecture02
 */
class User {
    private UserImpl realUser;

    public User(UserImpl impl) {
        realUser = impl;
    }

    public void run() {
        realUser.run();        //бежать
    }

    public void fly() {
        realUser.fly();        //лететь
    }

    public void transformToDonkey() {
        realUser = new UserDonkeyImpl();
        System.out.println("---Transform to Donkey---");
    }

    public void transformToDragon() {
        realUser = new UserDragonImpl();
        System.out.println("---Transform to Dragon---");
    }

    public static void main(String[] args) {
        User user = new User(new UserDonkeyImpl()); //внутри мы – осел
        user.run();
        user.fly();
        user.transformToDragon(); //теперь внутри мы – дракон
        user.run();
        user.fly();
    }
}

class UserImpl {
    public void run() {
    }

    public void fly() {
    }
}

class UserDonkeyImpl extends UserImpl {
    public void run() {
        System.out.println("Donkey run");
    }

    public void fly() {
        System.out.println("Donkey can't fly");
    }
}

class UserDragonImpl extends UserImpl {
    public void run() {
        System.out.println("Dragon can't run");
    }

    public void fly() {
        System.out.println("Dragon fly");
    }
}