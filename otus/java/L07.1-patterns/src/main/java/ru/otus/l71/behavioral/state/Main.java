package ru.otus.l71.behavioral.state;

/**
 * Created by tully.
 *
 * Client in the State pattern.
 */
public class Main {
    public static void main(String[] args) {
        StateContext context = new StateContext(new UpperCaseState());

        String str = "mAY the force BE WiTh you";
        System.out.println(str);
        for (Character character : str.toCharArray()) context.print(character);
    }
}
