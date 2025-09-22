package com.example.employee.entity;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;

@Embeddable
 public class Authorization {
        private String status;         // e.g., VERIFIED
        private LocalDate date;        // e.g., 2025-08-21

        public Authorization(String status, LocalDate date) {
            this.status = status;
            this.date = date;
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