package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.AdvanceType;
import com.example.employee.entity.SalaryHead;
import com.example.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController { 
    
    @Autowired
    private EmployeeService employeeService;
    

    @GetMapping("/viewAdvanceType")
    public List<AdvanceType> createEmployee() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/searchAdvanceType")
    public List<AdvanceType> searchAdvanceTypes(@RequestParam("data") String data) {
    return employeeService.searchAdvanceTypes(data);
    }
    // // adding record
    @PostMapping("/saveAdvanceType")
    public AdvanceType postMethodName(@RequestBody AdvanceType advanceType) {
        return employeeService.saveAdvanceType(advanceType);
    }
   @PutMapping("/updateAdvanceType/{id}")
    public ResponseEntity<String> updateAdvanceType(@PathVariable Long id, @RequestBody AdvanceType entity) {
    return employeeService.updateAdvanceType(id, entity);
    }
    @GetMapping("/getAllSalaryHead")
    public List<SalaryHead> getAllSalaryHead() {
    return employeeService.getAllSalaryHead();
    }

}
