package com.javacode.generics.company;

import com.javacode.generics.company.employees.*;

import java.util.*;

public class Department {
    private String name;
    private int employeeNumber;
    private List<Employee> employees = new ArrayList<>();

    public Department(String name, int employeeNumber) {
        this.name = name;
        this.employeeNumber = employeeNumber;
    }

    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Department{" + "name='" + name + '\'' +
                ", employeeNumber=" + employeeNumber +
//                ", employees=" + employees +
                '}';
    }
}
