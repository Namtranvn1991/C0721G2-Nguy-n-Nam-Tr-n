package com.casestudy.main.dto;


import com.casestudy.main.model.employee.Division;
import com.casestudy.main.model.employee.EducationDegree;
import com.casestudy.main.model.employee.Position;
import com.casestudy.main.model.user.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;

@Component
public class EmployeeDTO implements Validator {

    private Integer employeeId;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]*([ ][A-Z][a-z]*)*",message = "Name wrong format")
    @Size(min = 6,max = 40,message = "Name too short or too long. 6-40 chars")
    private String employeeName;

    @NotBlank(message = "input date")
    private String employeeBirthday;

    @NotBlank(message = "input this")
    @Pattern(regexp = "\\d{9}||\\d{12}",message = "XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String employeeIdCard;

    @NotNull
    private Double employeeSalary;


    @Pattern(regexp = "090\\d{7}||091\\d{7}||[(]84[)][+]90\\d{7}||[(]84[)][+]91\\d{7}",message = "phoneNumber wrong format 090xxxxxxx  091xxxxxxx (84)+90xxxxxxx (84)+91xxxxxxx")
    private String employeePhone;


    @Pattern(regexp = "[^\\s@]+@[^\\s@]+\\.[^\\s@]+",message = "Email wrong format. xxx@xx.xx")
    private String employeeEmail;


    private String employeeAddress;

    private String userName;
    private String password;

    private Position position;

    private EducationDegree educationDegree;

    private Division division;

    public EmployeeDTO() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTO employee =(EmployeeDTO) target;

        try {
            LocalDate birthDate = LocalDate.parse(employee.employeeBirthday);
            LocalDate today = LocalDate.now();
            if(Period.between(birthDate,today).getYears()<18){
                errors.rejectValue("employeeBirthday","birthday18");
            }
        } catch (Exception e){
            errors.rejectValue("employeeBirthday","birthday.empty");
        }
    }
}
