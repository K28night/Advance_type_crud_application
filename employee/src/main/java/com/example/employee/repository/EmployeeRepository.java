package com.example.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.employee.entity.AdvanceType;

public interface EmployeeRepository extends JpaRepository<AdvanceType, Long> {
    @Query("SELECT a FROM AdvanceType a " +
       "WHERE LOWER(a.code) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
       "OR LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
       "OR LOWER(a.shortName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
       "OR LOWER(a.description) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
       "OR LOWER(a.recoveryHead) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
       "OR CAST(a.activeDate AS string) LIKE CONCAT('%', :keyword, '%') " +
       "OR LOWER(a.status) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
       "OR CAST(a.date AS string) LIKE CONCAT('%', :keyword, '%')")
    List<AdvanceType> searchAdvanceTypes(@Param("keyword") String keyword);

    

}
