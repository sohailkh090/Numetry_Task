package com.example.Fetch_data_Pdf_d3.repository;
import com.example.Fetch_data_Pdf_d3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
