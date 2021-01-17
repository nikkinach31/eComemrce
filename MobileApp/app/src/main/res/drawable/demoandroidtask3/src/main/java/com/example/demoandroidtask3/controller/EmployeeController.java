package com.example.demoandroidtask3.controller;

import com.example.demoandroidtask3.entity.Employee;
import com.example.demoandroidtask3.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/findAll")
    List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping(value = "/save")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping(value = "/delete/{emailId}")
    public String deleteById(@PathVariable("emailId") String emailId) {
        employeeService.deleteById(emailId);
        return "User Deleted";
    }
}
