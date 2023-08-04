package com.example.task_2nd.services;

import com.example.task_2nd.model.Employee;
import com.example.task_2nd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee saveData(Employee  employee){

        return employeeRepository.save(employee);
    }
    public List<Employee> searchEmployeesByName(String name) {
        return employeeRepository.searchByName(name);
    }
}
