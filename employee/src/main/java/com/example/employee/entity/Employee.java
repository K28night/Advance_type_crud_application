package com.example.employee.entity;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false, unique = true)
    private String code;

    private String salutation;

    @Column(nullable = false)
    private String name;

    private String gender;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String maritalStatus;

    private String nationality;

    private String religion;

    private String bloodGroup;

    private String mobileNumber;

    private String emergencyContact;

    private String landlineNumber;

    private String email;

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
    public String getSalutation() {
        return salutation;
    }
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }  
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality){
        this.nationality=nationality;
    }
    public String getReligion() {
        return religion;
    }
    public void setReligion(String religion){
        this.religion=religion;
    }
    public String getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup){
        this.bloodGroup=bloodGroup;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber=mobileNumber;
    }
    public String getEmergencyContact() {
        return emergencyContact;
    }
    public void setEmergencyContact(String emergencyContact){
        this.emergencyContact=emergencyContact;
    }
    public String getLandlineNumber() {
        return landlineNumber;
    }
    public void setLandlineNumber(String landlineNumber){
        this.landlineNumber=landlineNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    
}
