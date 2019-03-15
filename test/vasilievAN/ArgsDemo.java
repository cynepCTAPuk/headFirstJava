package vasilievAN;

class Args {
    // Поля класса:
    int number;
    char symb;

    // Конструктор класса:
    Args(int number, char symb) {
// Для различения полей и аргументов используем ключевое слово this:
        this.number = number;
        this.symb = symb;
    }

    // Метод для отображения значений полей объекта:
    void show() {
        System.out.println("Поля объекта: " + number + " и " + symb);
    }
}

class ArgsDemo {
    // Перегруженный статический метод. Аргумент - объект:
    static void MakeChange(Args obj) {
// Изменение полей объекта - аргумента метода:
        obj.number++;
        obj.symb++;
// Текст для отображения:
        String text = "Аргумент-объект: поля " + obj.number + " и " + obj.symb;
        System.out.println(text); // Вывод сообщения на консоль:
    }

    // Перегруженный статический метод. Аргументы - переменные базовых типов:
    static void MakeChange(int number, char symb) {
// Изменение аргументов метода:
        number++;
        symb++;
// Текст для отображения:
        String text = "Аргументы базовых типов: значения " + number + " и " + symb;
        System.out.println(text); // Вывод сообщения на консоль:
    }

    // Главный метод программы:
    public static void main(String[] args) {
        Args obj = new Args(1, 'a'); // Создание объекта:
        obj.show(); // Значения полей объекта:
        MakeChange(obj); // Изменение объекта:
        obj.show(); // Значения полей объекта:
        MakeChange(obj.number, obj.symb); // Изменение полей объекта:
        obj.show(); // Значения полей объекта:
    }
}