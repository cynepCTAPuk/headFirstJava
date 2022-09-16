package jUnit.t605;
/**
 * https://javarush.ru/groups/posts/606-junit-part-ii
 * https://www.youtube.com/watch?v=lTAmF0tB3e4&t=2693s
 * https://www.youtube.com/watch?v=aGsQmbSNPR8&t=59s
 */

import java.util.*;

public class User2 {
    private int id;
    private String name;
    private int age;
    private Sex sex;
    private static Map<Integer, User2> allUsers = new HashMap<>();
    private static int countId = 0;

    public User2(String name, int age, Sex sex) {
        if (name != null && !name.isEmpty() && age > 0 && sex != null) {
            this.name = name;
            this.age = age;
            this.sex = sex;

            if (!hasUser()) {
                countId++;
                this.id = countId;
                allUsers.put(id, this);
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    private boolean hasUser() {
        for (User2 user : allUsers.values())
            if (user.equals(this) && user.hashCode() == this.hashCode())
                return true;
        return false;
    }

    public static List<User2> getAllUsers() {
        return new ArrayList<>(allUsers.values());
    }

    public static List<User2> getAllUsers(Sex sex) {
        List<User2> listAllUsers = new ArrayList<>();
        for (User2 user : allUsers.values())
            if (user.sex == sex)
                listAllUsers.add(user);
        return listAllUsers;
    }

    public static int getHowManyUsers() {
        return allUsers.size();
    }

    public static int getHowManyUsers(Sex sex) {
        return getAllUsers(sex).size();
    }

    public static int getAllAgeUsers() {
        int countAge = 0;
        for (User2 user : allUsers.values())
            countAge += user.age;
        return countAge;
    }

    public static int getAllAgeUsers(Sex sex) {
        int countAge = 0;
        for (User2 user : getAllUsers(sex))
            countAge += user.age;
        return countAge;
    }

    public static int getAverageAgeOfAllUsers() {
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(Sex sex) {
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User2 user = (User2) o;
        return age == user.age && Objects.equals(name, user.name) && sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public static void main(String[] args) {
        new User2("Евгений", 35, Sex.MALE);
        new User2("Марина", 34, Sex.FEMALE);
        new User2("Алина", 7, Sex.FEMALE);

        System.out.println("Все пользователи:");
        User2.getAllUsers().forEach(System.out::println);
        System.out.println("Все пользователи: MALE");
        User2.getAllUsers(Sex.MALE).forEach(System.out::println);
        System.out.println("Все пользователи: FEMALE");
        User2.getAllUsers(Sex.FEMALE).forEach(System.out::println);
        System.out.println("================================================");
        System.out.println("       всех пользователей: " + User2.getHowManyUsers());
        System.out.println("  всех пользователей MALE: " + User2.getHowManyUsers(Sex.MALE));
        System.out.println("всех пользователей FEMALE: " + User2.getHowManyUsers(Sex.FEMALE));
        System.out.println("================================================");
        System.out.println("       общий возраст всех пользователей: " + User2.getAllAgeUsers());
        System.out.println("  общий возраст всех пользователей MALE: " + User2.getAllAgeUsers(Sex.MALE));
        System.out.println("общий возраст всех пользователей FEMALE: " + User2.getAllAgeUsers(Sex.FEMALE));
        System.out.println("================================================");
        System.out.println("       средний возраст всех пользователей: " + User2.getAverageAgeOfAllUsers());
        System.out.println("  средний возраст всех пользователей MALE: " + User2.getAverageAgeOfAllUsers(Sex.MALE));
        System.out.println("средний возраст всех пользователей FEMALE: " + User2.getAverageAgeOfAllUsers(Sex.FEMALE));
        System.out.println("================================================");
    }
}
