package com.example.task_2nd.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "name can not be null")
    private String name;
    @Size(min = 5, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;
    @Email(message = "Please provide a valid email address")
    private String email;



}
