package com.example.demoandroidtask3.services.impl;

import com.example.demoandroidtask3.entity.Employee;
import com.example.demoandroidtask3.repository.EmployeeRepository;
import com.example.demoandroidtask3.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(String emailId) {
         employeeRepository.deleteById(emailId);
    }

    @Override
    public List<Employee> findAll() {
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        employeeIterable.forEach(employeeList::add);
        return employeeList;
    }
}
