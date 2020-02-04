package games.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse h : horses) h.move();
    }

    public void print() {
        for (Horse h : horses) h.print();
        for (int i = 0; i < 10; i++) System.out.println();
    }

    public Horse getWinner() {
        double result = 0;
        Horse winner = null;
        for (Horse h : horses) {
            if (h.getDistance() > result) {
                result = h.getDistance();
                winner = h;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + '!');
    }

    public static void main(String[] args) {
        List<Horse> list = new ArrayList<>();
        Horse one = new Horse("One", 3, 0);
        Horse two = new Horse("Two", 3, 0);
        Horse three = new Horse("Three", 3, 0);
        list.add(one);
        list.add(two);
        list.add(three);

        Hippodrome hippodrome = new Hippodrome(list);
        Hippodrome.game = hippodrome;

        game.run();
        game.printWinner();
    }
}
