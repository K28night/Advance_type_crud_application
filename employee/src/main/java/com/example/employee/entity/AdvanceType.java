package com.example.employee.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdvanceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    

    @Column(nullable = false, unique = true)
    private String code;  

    private String name;               
    private String shortName;  

    @Column(nullable = false)
    private String recoveryHead;       
    private String description;        
    private LocalDate activeDate;
    private String status;         // e.g., VERIFIED
    private LocalDate date;        // e.g., 2025-08-21


    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public String getRecoveryHead() {
        return recoveryHead;
    }  
    public void setRecoveryHead(String recoveryHead) {
        this.recoveryHead = recoveryHead;
    }
    public String getDescription() {
        return description;
    }  
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getActiveDate() {
        return activeDate;
    }  
    public void setActiveDate(LocalDate activeDate) {
        this.activeDate = activeDate;
    }
    public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }
}
