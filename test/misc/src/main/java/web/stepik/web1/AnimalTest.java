package web.stepik.web1;

/**
 * https://stepik.org/lesson/12497/step/2?unit=2967
 * 2.3 "Углубленные" основы языка
 */
public class AnimalTest {
    public static void main(String[] args) throws ClassNotFoundException {
//        Animal animal = new Animal();

//        Animal elephant = new Elephant();
        Elephant elephant = new Elephant();
        boolean isDangerous = elephant.isDangerous();
        jump(elephant);

//        Mouse mouse;
        Jumpable mouse;
        mouse = new Mouse();
//        boolean isMouseDangerous = mouse.isDangerous();
        jump(mouse);

        Class clazz = elephant.getClass();
        System.out.println(clazz.getSuperclass().getModule());
    }

    private static void jump(Jumpable object) {
        if (object.canJump()) System.out.println(object + " can jump!");
        else System.out.println("Oops! " + object + " can't jump!");
    }
}

class Mouse extends Animal implements Jumpable {

    public Mouse() {
        super(1);
    }

    @Override
    boolean isPredator() {
        return false;
    }

    @Override
    public boolean canJump() {
        return true;
    }
}

class Elephant extends Animal implements Jumpable {
    private boolean canJump = false;

    public Elephant() {
        super(200);
    }

    @Override
    boolean isPredator() {
        return false;
    }

    @Override
    public boolean canJump() {
        return canJump;
    }
}

abstract class Animal {
    private int weight;

    public Animal(int weight) {
        this.weight = weight;
    }

    protected int getWeight() {
        return weight;
    }

    abstract boolean isPredator();

    public boolean isDangerous() {
        return isPredator() || getWeight() > 15;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

interface Jumpable {
    boolean canJump();
}