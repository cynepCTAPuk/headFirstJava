package org.sample;

public class Person {
    private String name;
    private int age;
    private int childern;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChildern() {
        return childern;
    }

    public void setChildern(int childern) {
        this.childern = childern;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", childern=" + childern +
                '}';
    }
}
