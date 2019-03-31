package ru.otus.task1;

public class MainABC {
    public static void main(String[] args) {
        A aC = new C();
        B bB = new B();
        System.out.println(aC.dif(1, 2) - bB.dif(2, 1));
    }
}
