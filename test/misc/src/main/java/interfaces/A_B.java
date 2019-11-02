package com.example.interfaces;

class A implements B {
    @Override
    public int methodB(int i) {
        return i = +i * i;
    }
}

interface B {
    int methodB(int i);
}

public class A_B {
    public static void main(String[] args) {
        B b = new A();
        System.out.println(b.methodB(2));
    }
}


