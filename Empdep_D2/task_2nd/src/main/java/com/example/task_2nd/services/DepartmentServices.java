package com.example.task_2nd.services;

import com.example.task_2nd.model.Department;
import com.example.task_2nd.model.Employee;
import com.example.task_2nd.repository.DepartmentRepository;
import com.example.task_2nd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServices {
    @Autowired
    private DepartmentRepository departmentRepository;
    public Department saveData(Department  department){

        return departmentRepository.save(department);
    }
}
