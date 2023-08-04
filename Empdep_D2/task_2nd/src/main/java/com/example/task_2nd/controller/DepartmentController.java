package com.example.task_2nd.controller;

import com.example.task_2nd.model.Department;
import com.example.task_2nd.model.Employee;
import com.example.task_2nd.services.DepartmentServices;
import com.example.task_2nd.services.EmployeeServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DepartmentController {
    @Autowired
    private DepartmentServices departmentServices;
    @PostMapping("/dep")
    public Department saveData(@RequestBody @Valid Department department)
    {
        return departmentServices.saveData(department);
    }
}
