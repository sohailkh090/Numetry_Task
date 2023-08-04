package com.example.task_2nd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "department name can not be null")
    private String department;
    @ManyToMany()
    @JoinTable(name="emp_dep",
            joinColumns = {@JoinColumn(name="dep_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="emp_id",referencedColumnName = "id")}
    )
    private List<Employee > employeesList;



}
