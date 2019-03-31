package ru.otus.varArgs;

public class Main {
    public static void main(String[] args) {
        System.out.println(VarArgs.addAll());
        System.out.println(VarArgs.addAll(1));
        System.out.println(VarArgs.addAll(1, 2));
        System.out.println(VarArgs.addAll(1, 2, 3));
        System.out.println(VarArgs.addAll(1, 2, 3, 4));
    }
}
