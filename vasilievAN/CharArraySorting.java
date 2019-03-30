package vasilievAN;

import javax.swing.*;

public class CharArraySorting {
    public static void main(String[] args) {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder("Исходный массив:\n");
        int size = Integer.parseInt(JOptionPane.showInputDialog("Размер массива: "));
        char[] symbs = new char[size];
        char ch = 'a';
        for (int i = 0; i < size; i++) {
            symbs[i] = (char) (ch + (byte) (Math.random() * 26));
            stringBuilder.append(symbs[i] + " ");
        }
        stringBuilder.append("\nПосле сортировки:\n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (symbs[j] > symbs[j + 1]) {
                    ch = symbs[j + 1];
                    symbs[j + 1] = symbs[j];
                    symbs[j] = ch;
                }
            }
        }
        for (int i = 0; i <size ; i++) {
            stringBuilder.append(symbs[i] + " ");
        }
//        JOptionPane.showMessageDialog(null,stringBuilder);
        System.out.println(stringBuilder);
    }
}

