package vasilievAN;

// Описание класса:
class MyClass5 {
    int num;
    char symb;
    String text;

    // Конструктор класса без аргументов:
    MyClass5() {
        set(); // Заполнение полей:
        showText(); // Отображение сообщения с информацией об объекте:
    }

    // Конструктор класса с целочисленным аргументом:
    MyClass5(int n) {
        set(n); // Заполнение полей:
        showText(); // Отображение сообщения с информацией об объекте:
    }

    // Конструктор класса с символьным аргументом:
    MyClass5(char s) {
        set(s); // Заполнение полей:
        showText(); // Отображение сообщения с информацией об объекте:
    }

    // Конструктор класса с тремя аргументами:
    MyClass5(int n, char s, String str) {
        set(n, s, str); // Заполнение полей:
        showText(); // Отображение сообщения с информацией об объекте:
    }

    // Метод класса для отображения сообщения:
    private void showText() {
        String str = "Значения полей объекта:\t"; // Локальная текстовая переменная:
// Формирование результата (значения локальной переменной):
        str += "num = " + num + "\t";
        str += "symb = " + symb + "\t";
        str += "text = " + text;
//        JOptionPane.showMessageDialog(null, str); // Метод отображает окно сообщения:
        System.out.println(str);
    }

    // Метод класса для присваивания значений полям (нет аргументов):
    void set() {
// Заполнение полей:
        num = 0;
        symb = 'a';
        text = "Нет аргументов.";
    }

    // Метод класса для присваивания значений полям (целочисленный аргумент):
    void set(int n) {
// Заполнение полей:
        num = n;
        symb = 'b';
        text = "Целочисленный аргумент.";
    }

    // Метод класса для присваивания значений полям (символьный аргумент):
    void set(char s) {
// Заполнение полей:
        num = 1;
        symb = s;
        text = "Символьный аргумент.";
    }

    // Метод класса для присваивания значений полям (три аргумента):
    void set(int n, char s, String str) {
// Заполнение полей:
        num = n;
        symb = s;
        text = str;
    }
}

public class Class5Demo {
    public static void main(String[] args) {
// Создание объектов:
        MyClass5 obj1 = new MyClass5();
        MyClass5 obj2 = new MyClass5(2);
        MyClass5 obj3 = new MyClass5('Z');
        MyClass5 obj4 = new MyClass5(3, 'A', "Три аргумента.");
    }
}