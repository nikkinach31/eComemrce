package com.example.demoandroidtask3.services;

import com.example.demoandroidtask3.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);
    void deleteById(String emailId);
    List<Employee> findAll();
}
