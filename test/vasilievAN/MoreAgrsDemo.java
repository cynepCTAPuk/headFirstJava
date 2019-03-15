package vasilievAN;

class MoreArgs {
    // Имя объекта (текстовое поле):
    String name;

    // Конструктор класса:
    MoreArgs(String name) {
        this.name = name;
    }

    // Метод для отображения имени объекта:
    void show() {
        System.out.println("Объект с именем \"" + name + "\".");
    }
}

class MoreArgsDemo {
    private static void ChangeRef(MoreArgs obj) {
        MoreArgs tmp = new MoreArgs("Локальный Объект"); // Создается локальный объект:
        obj = tmp; // Ссылка на локальный объект присваивается аргументу метода:
        obj.show(); // Проверка имени объекта, на который ссылается аргумент:
    }

    // Статический метод для изменения ссылки на объект:
    public static void main(String[] args) {
        MoreArgs obj = new MoreArgs("Основной Объект"); // Создание объекта:
        obj.show(); // Проверка имени объекта:
        ChangeRef(obj); // Попытка изменить ссылку на объект:
        obj.show(); // Проверка результата:
    }
}