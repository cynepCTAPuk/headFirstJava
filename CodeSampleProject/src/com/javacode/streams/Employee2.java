package com.javacode.streams;

public class Employee2 {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private String department;

    public Employee2(int id, String firstName, String lastName, int salary, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee2 employee2 = (Employee2) o;

        if (id != employee2.id) return false;
        if (salary != employee2.salary) return false;
        if (firstName != null ? !firstName.equals(employee2.firstName) : employee2.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee2.lastName) : employee2.lastName != null) return false;
        return department != null ? department.equals(employee2.department) : employee2.department == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                String.format(", salary=%,d", salary) +
                ", department='" + department + '\'' +
                '}';
    }

}
