package com.javacode.generics.company;

import com.javacode.generics.company.employees.*;

public class CompanyMain {
    public static void main(String[] args) {
        Company company = new Company();

        Department<Accountant> accounting = new Department<>("Accounting", 5);
        Department<Manager> management = new Department<>("Management", 2);
        Department<ITSpecialist> itGuys = new Department<>("Management", 10);

        Accountant accountant = new Accountant("Alex", 1_000.0f);
        ITSpecialist it = new ITSpecialist("James", 2_000.0f);
        Manager manager = new Manager("Michal", 4_000.0f);

        accounting.addEmployee(accountant);
        itGuys.addEmployee(it);
        management.addEmployee(manager);

        company.addDepartment(accounting);
        company.addDepartment(itGuys);
        company.addDepartment(management);

//        System.out.println(company);
        company.print(company.getDepartments());
        company.print(company.getEmployees());

        company.addToItEmployees(itGuys.getEmployees());
        company.addToItEmployees(company.getEmployees());

        company.print(company.getDepartments());
        company.print(company.getEmployees());
    }
}
