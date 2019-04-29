package chap05_singleton;

public class ChocolateBoilerSingleton {
    private static ChocolateBoilerSingleton uniqueInstance;
    private boolean empty = true;
    private boolean boiled;

    private ChocolateBoilerSingleton() {
    }

    public static ChocolateBoilerSingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ChocolateBoilerSingleton();
            uniqueInstance.isEmpty();
        }
        return uniqueInstance;
    }


    public void fill() {
// Заполнение нагревателя молочно-шоколадной смесью
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
// Слить нагретое молоко и шоколад
        if (!isEmpty() && isBoiled()) empty = true;
    }

    public void boil() {
// Довести содержимое до кипения
        if (!isEmpty() && !isBoiled()) boiled = true;
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }

    @Override
    public String toString() {
        return "ChocolateBoilerSingleton{" +
                "empty=" + empty + ", boiled=" + boiled + '}';
    }

    public static void main(String[] args) {
        ChocolateBoilerSingleton boilerSingleton = getInstance();
        System.out.println(boilerSingleton + " create");
        boilerSingleton.fill();
        System.out.println(boilerSingleton + " fill");
        boilerSingleton.boil();
        System.out.println(boilerSingleton + " boiled");
    }
}