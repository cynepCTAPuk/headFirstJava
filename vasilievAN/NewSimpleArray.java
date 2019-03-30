package vasilievAN;

import javax.swing.*;
import java.util.Arrays;

public class NewSimpleArray {
    public static void main(String[] args) {
// Размеры массива:
        int n, m;
// Текст для отображения в окне:
//        String text = "Двумерный массив случайных чисел:";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Двумерный массив случайных чисел:");
// Считывание размеров массива:
        n = Integer.parseInt(JOptionPane.showInputDialog("Строк в массиве:"));
        m = Integer.parseInt(JOptionPane.showInputDialog("Столбцов в массиве:"));
// Создание массива:
        int[][] nums = new int[n][m];
// Заполнение массива случайными числами:
        for (int i = 0; i < n; i++) {
//            text += "\n";
            stringBuilder.append("\n");

            for (int j = 0; j < m; j++) {
                nums[i][j] = (int) (100 * Math.random());
//                text += nums[i][j] + " ";
                stringBuilder.append(nums[i][j] + " ");
            }
        }
// Вывод окна сообщения с элементами массива:
//        JOptionPane.showMessageDialog(null, text);
        JOptionPane.showMessageDialog(null, stringBuilder);
//        System.out.println(text);
        System.out.println(stringBuilder);
        System.out.println(Arrays.deepToString(nums));
    }
}