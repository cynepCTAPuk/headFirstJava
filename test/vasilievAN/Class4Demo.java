package vasilievAN;

class MyClass4 {
    private int num;
    private char symb;
    private String text;

    // Конструктор класса с тремя аргументами:
    MyClass4(int num, char symb, String text) {
        set(num, symb, text); // Заполнение полей:
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
        System.out.print(str);
    }

    // Метод класса для присваивания значений полям:
    void set(int num, char symb, String text) {
        // Заполнение полей:
        this.num = num;
        this.symb = symb;
        this.text = text;
    }
}

// Главный класс программы:
class Class4Demo {
    public static void main(String[] args) {
// Создание объекта с передачей аргументов конструктору:
        MyClass4 obj = new MyClass4(15, 'Ы', "Просто текст");
    }
}