package patterns.template.tutorialspoint.com;

public class GameDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        System.out.println();

        game = new Football();
        game.play();
    }

}
