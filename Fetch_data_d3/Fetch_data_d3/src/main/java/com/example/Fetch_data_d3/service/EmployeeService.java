package com.example.Fetch_data_d3.service;

import com.example.Fetch_data_d3.model.Employee;
import com.example.Fetch_data_d3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository  employeeRepository;
    public Employee saveData(Employee  employee) {

        return employeeRepository.save(employee);
    }


    }
