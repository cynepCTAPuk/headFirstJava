package vasilievAN;

import javax.swing.*;

public class MakeChoice {
    public static void main(String[] args) {
        int number = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Введите число:",
                "100"));
        String text = number % 2 == 0 ? "чётное" : "нечётное";
        JOptionPane.showMessageDialog(
                null,
                "Вы ввели число " + number + ". Это " + text + " число!",
                "Итог", JOptionPane.INFORMATION_MESSAGE);
    }
}
