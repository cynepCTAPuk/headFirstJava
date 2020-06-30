package com.example.web.controller;

import com.example.web.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    Employee employee = new Employee();

    @RequestMapping(value = "employees", method = RequestMethod.GET, produces = "application/json")
    public Employee getEmployeeInJSON(@RequestParam(value = "name", defaultValue = "anonymous") String name) {
        employee.setName(name);
        employee.setEmail(name + "@example.com");
        return employee;
    }
}