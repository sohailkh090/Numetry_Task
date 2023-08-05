package com.example.Fetch_data_d3.controller;
import com.example.Fetch_data_d3.model.Employee;
import com.example.Fetch_data_d3.repository.EmployeeRepository;
import com.example.Fetch_data_d3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
@Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping
    public Employee saveData(@RequestBody Employee employee)
    {
        return  employeeService.saveData(employee);
    }


    @GetMapping
    public List<Employee> getRecordsBetweenDates(@RequestParam  LocalDate startDate,
                                               @RequestParam LocalDate endDate) {

        return employeeRepository.findRecordsBetweenDates(startDate, endDate);
    }



}
