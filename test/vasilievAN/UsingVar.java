package vasilievAN;

import javax.swing.*;

public class UsingVar {
    public static void main(String[] args) {
        String name = "Иванов Иван Иванович";
        int age = 60;
        char category = 'B';
        StringBuilder text = new StringBuilder();
        text.append("Водитель: " + name);
        text.append("\n" + "Возраст: " + age + "лет");
        text.append("\n" + "Права категории: " + category);
        JOptionPane.showMessageDialog(null,text);
    }
}
