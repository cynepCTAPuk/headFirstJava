package refactor.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student s : students) if (s.getAverageGrade() == averageGrade) return s;
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        return Collections.max(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getAverageGrade() - o2.getAverageGrade());
            }
        });
    }

    public Student getStudentWithMinAverageGrade() {
        return Collections.min(students, Comparator.comparingDouble(Student::getAverageGrade));
    }

    public void expel(Student student) {
        students.remove(student);
    }
}