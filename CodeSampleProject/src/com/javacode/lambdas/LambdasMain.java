package com.javacode.lambdas;

import java.util.*;

public class LambdasMain {
    public static void main(String[] args) {
        String[] colours = {"green", "brown", "black", "blue", "pink", "grey"};
        Player player1 = new Player("Alex", 100);
        Player player2 = new Player("Victor", 80);
        Player player3 = new Player("Igor", 80);
        Player player4 = new Player("John", 91);
        Player[] players = {player1, player2, player3, player4};

//        Arrays.sort(colours);
        Arrays.sort(colours, new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1);
            }
        });
        System.out.println(Arrays.toString(colours));

        Arrays.sort(colours, (s1, s2) -> s1.charAt(s1.length() - 2) - s2.charAt(s2.length() - 2));
        System.out.println(Arrays.toString(colours));

        Arrays.sort(players, new Comparator<>() {
            @Override
            public int compare(Player p1, Player p2) {
                return p1.score - p2.score;
            }
        });
        System.out.println(Arrays.toString(players));

        Arrays.sort(players, (p1, p2) -> (p2.score - p1.score));
        System.out.println(Arrays.toString(players));

        Arrays.sort(players, (p1, p2) -> {
            if ((p2.score - p1.score) != 0) return p2.score - p1.score;
            else return p1.name.charAt(0) - p2.name.charAt(0);
        });
        System.out.println(Arrays.toString(players));

        Thread thread = new Thread(() -> System.out.println("Hello world!"));
        thread.start();
    }

    private static class Player {
        private String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
