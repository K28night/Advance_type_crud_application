package com.example.employee.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.employee.entity.AdvanceType;
import com.example.employee.entity.SalaryHead;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.SalaryHeadRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SalaryHeadRepository salaryHeadRepository;

    public List<AdvanceType> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<AdvanceType> searchAdvanceTypes(String data) {
        return employeeRepository.searchAdvanceTypes(data);
    }

    public AdvanceType saveAdvanceType(AdvanceType advanceType) {
    
      return employeeRepository.save(advanceType);
    }

    public ResponseEntity<String> updateAdvanceType(Long id, AdvanceType entity) {
        AdvanceType existing=employeeRepository.findById(id).orElseThrow(null);
        // Here, you would typically update the entity with new values from the request body.
        // For simplicity, we're just returning a success message.
        
        if(existing!=null){
             BeanUtils.copyProperties(entity, existing, "id");
            employeeRepository.save(existing);
        }
        return ResponseEntity.ok("AdvanceType with ID " + id + " updated successfully.");
    }

    public List<SalaryHead> getAllSalaryHead() {
      return salaryHeadRepository.findAll();
      
    }
    
}
