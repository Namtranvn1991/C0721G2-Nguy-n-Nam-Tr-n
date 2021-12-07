package com.casestudy.main.model.employee;


import com.casestudy.main.model.user.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Employee implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

//    @NotBlank
    @Column(columnDefinition = "VARCHAR(45)")
//    @Pattern(regexp = "[A-Z][a-z]*([ ][A-Z][a-z]*)*",message = "Name wrong format")
//    @Size(min = 6,max = 40,message = "Name too short or too long. 6-40 chars")
    private String employeeName;

//    @NotBlank(message = "input date")
    @Column(columnDefinition = "DATE")
    private String employeeBirthday;

//    @NotBlank(message = "input this")
    @Column(columnDefinition = "VARCHAR(45)")
//    @Pattern(regexp = "\\d{9}||\\d{12}",message = "XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String employeeIdCard;

    @NotNull
    @Column(columnDefinition = "DOUBLE")
    private Double employeeSalary;

//    @NotBlank(message = "input this")
    @Column(columnDefinition = "VARCHAR(45)")
//    @Pattern(regexp = "090\\d{7}||091\\d{7}||[(]84[)][+]90\\d{7}||[(]84[)][+]91\\d{7}",message = "phoneNumber wrong format 090xxxxxxx  091xxxxxxx (84)+90xxxxxxx (84)+91xxxxxxx")
    private String employeePhone;

//    @NotBlank(message = "input this")
    @Column(columnDefinition = "VARCHAR(45)")
//    @Pattern(regexp = "[^\\s@]+@[^\\s@]+\\.[^\\s@]+",message = "Email wrong format. xxx@xx.xx")
    private String employeeEmail;

    @Column(columnDefinition = "VARCHAR(45)")
    private String employeeAddress;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "userName")
    private User userName;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "positionId")
    private Position position;

    @ManyToOne(targetEntity = EducationDegree.class)
    @JoinColumn(name = "educationDegreeId")
    private EducationDegree educationDegree;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "divisionId")
    private Division division;

    public Employee() {
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

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
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
        Employee employee =(Employee) target;

        try {
            LocalDate birthDate = LocalDate.parse(employee.employeeBirthday);
            LocalDate today = LocalDate.now();
            if(Period.between(birthDate,today).getYears()<18){
                errors.rejectValue("customerBirthday","birthday18");
            }
        } catch (Exception e){
            errors.rejectValue("customerBirthday","birthday.empty");
        }

    }
}
