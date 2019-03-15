package vasilievAN;

import javax.swing.*;

class UsingStat {
    static int N1; // Статическое поле класса:
    int N2; // Нестатическое поле:

    UsingStat(int n1, int n2) {
        N1 = n1;
        N2 = n2;
// Текст для отображения в окне:
        String text = "Создан новый объект!\n";
        text += "Статическое поле: " + N1 + "\n";
        text += "Нестатическое поле: " + N2;
        JOptionPane.showMessageDialog(null, text); // Отображение окна сообщения:
    } // Конструктор класса:

    void show() {
// Текст для отображения в окне:
        String text = "Поля объекта!\n";
        text += "Статическое поле: " + N1 + "\n";
        text += "Нестатическое поле: " + N2;
        JOptionPane.showMessageDialog(null, text); // Отображение окна:
    } // Метод для отображения значений полей:
}

class UsingStatDemo {
    public static void main(String[] args) {
        UsingStat A = new UsingStat(10, 200); // Создание объекта:
        UsingStat.N1 = -50;// Изменение значения статического поля (использована ссылка на класс):
        A.show(); // Отображение полей объекта:
        UsingStat B = new UsingStat(1, 2); // Создание нового объекта:
        A.show(); // Отображение полей первого объекта:
        B.N1 = -1; // Изменение статического поля (использована ссылка на объект):
        B.N2 = -2; // Изменение нестатического поля объекта:
        A.show(); // Проверка значений первого объекта:
    }
}