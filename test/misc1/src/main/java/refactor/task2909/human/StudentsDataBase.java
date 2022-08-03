package refactor.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

    public static void addInfoAboutStudent(Student student) {
        students.add(student);
        printInfoAboutStudent(student);
    }

    public static void printInfoAboutStudent(Student student) {
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }

    public static void removeStudent(int index) {
        if (index < students.size() && index >= 0) students.remove(index);
    }

    public static void findDimaOrSasha() {
        for (Student s : students) {
            if (s.getName().equals("Dima") || s.getName().equals("Sasha")) {
                System.out.println("Студент " + s.getName() + " есть в базе.");
                break;
            }
        }
    }
}