package beginning.testing;

import beginning.testing.good.*;

public class Main {
    public static void main(String[] args) {
        Bird[] birds = new Bird[]{
                new Crow("Crow"),
                new Blackbird("Blackbird")
        };
        birds[0].feed();
        birds[1].feed();
        new Main().print(birds);
    }

    private void print(Bird[] birds) {
        for (Bird bird : birds) {
            System.out.println(bird);
        }
    }
}
