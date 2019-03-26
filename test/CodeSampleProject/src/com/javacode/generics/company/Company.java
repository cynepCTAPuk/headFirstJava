package com.javacode.generics.company;

import com.javacode.generics.company.employees.*;

import java.util.*;

public class Company {
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public void addDepartment(Department department) {
        departments.add(department);
        List<Employee> employeeList = department.getEmployees();
        this.employees.addAll(employeeList);
    }
    public List<Department> getDepartments() {
        return departments;
    }
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "departments=" + departments +
                ", employees=" + employees +
                '}';
    }
}
