package com.example;

import java.io.*;

public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bare hands", "big axe"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[]{"spells", "invisibility"});

        //imagine code that does things with the characters that might chane their state values

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("src/Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("One's type\t "+oneRestore.getType());
            System.out.println("Two's type\t "+twoRestore.getType());
            System.out.println("Three's type\t "+threeRestore.getType());

            System.out.println("One's weapons\t "+oneRestore.getWeapons());
            System.out.println("Two's weapons\t "+twoRestore.getWeapons());
            System.out.println("Three's weapons\t "+threeRestore.getWeapons());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
