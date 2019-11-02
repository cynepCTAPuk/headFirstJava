package com.example;

import java.util.*;

public class CountCharsInString {

    public static void main(String[] args) {
        String string = "Hello my little friends!";
        System.out.println(string);
        Elements elements = new Elements();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);

            elements.put(c);
        }
        System.out.println("map = " + map);

        System.out.println(elements);
    }

}


class Element {
    private char key;
    private int value;

    public Element(char key) {
        value = 1;
        this.key = key;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}

class Elements {
    private Element[] elements;
    int arraySize;
    int idx;

    Elements() {
        arraySize = 20;
        elements = new Element[arraySize];
        idx = -1;
    }

    boolean put(char key) {
        if (idx == arraySize - 1) return false;
        if (idx == -1) {
            elements[++idx] = new Element(key);
            return true;
        }
        int index = getIndex(key);
        int value = getValue(key);

        if (value == -1) elements[++idx] = new Element(key);
        else elements[index].setValue(value + 1);
        return true;
    }

    int getIndex(char key) {
        for (int i = 0; i <= idx; i++)
            if (elements[i].getKey() == key)
                return i;
        return -1;
    }

    int getValue(char key) {
        if (getIndex(key) != -1) return elements[getIndex(key)].getValue();
        else return -1;
    }

    @Override
    public String toString() {
        String display = "elm = {";
        for (int i = 0; i <= idx; i++) {
            if (i == idx) display += elements[i];
            else display += elements[i] + ", ";
        }
        return display + '}';
    }

}