package com.example.Fetch_data_d3.repository;
import com.example.Fetch_data_d3.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT r FROM Employee r WHERE r.doj BETWEEN :startDate AND :endDate")
    List<Employee> findRecordsBetweenDates(@Param("startDate") LocalDate startDate,
                                         @Param("endDate") LocalDate endDate);

}

