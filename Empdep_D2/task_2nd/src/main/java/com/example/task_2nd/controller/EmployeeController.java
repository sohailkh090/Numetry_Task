package com.example.task_2nd.controller;

import com.example.task_2nd.model.Employee;
import com.example.task_2nd.services.EmployeeServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;
@PostMapping("/emp")
    public Employee saveData(@RequestBody @Valid Employee employee)
    {
       return employeeServices.saveData(employee);
    }

    @GetMapping("/search")
    public List<Employee> searchEmployeesByName(@RequestParam String name) {
        return employeeServices.searchEmployeesByName(name);
    }

}
