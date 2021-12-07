package com.casestudy.main.model.customer;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Customer  implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @NotBlank
    @Column(columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "[A-Z][a-z]*([ ][A-Z][a-z]*)*",message = "Name wrong format")
    @Size(min = 6,max = 40,message = "Name too short or too long. 6-40 chars")
    private String customerName;

    @NotBlank(message = "input date")
    @Column(columnDefinition = "DATE")
    private String customerBirthday;

    @NotNull(message = "input this")
    @Column(columnDefinition = "BIT(1)")
    private boolean gender;

    @NotBlank(message = "input this")
    @Column(columnDefinition = "VARCHAR(45)",unique=true)
    @Pattern(regexp = "\\d{9}||\\d{12}",message = "XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String customerIdCard;

    @NotBlank(message = "input this")
    @Column(columnDefinition = "VARCHAR(45)",unique=true)
    @Pattern(regexp = "090\\d{7}||091\\d{7}||[(]84[)][+]90\\d{7}||[(]84[)][+]91\\d{7}",message = "phoneNumber wrong format 090xxxxxxx  091xxxxxxx (84)+90xxxxxxx (84)+91xxxxxxx")
    private String customerPhone;

    @NotBlank(message = "input this")
    @Column(columnDefinition = "VARCHAR(45)",unique=true)
    @Pattern(regexp = "[^\\s@]+@[^\\s@]+\\.[^\\s@]+",message = "Email wrong format. xxx@xx.xx")
    private String customerEmail;

    @Column(columnDefinition = "VARCHAR(45)")
    private String customerAddress;

    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customerTypeId")
    private CustomerType customerType;

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Customer() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer =(Customer)target;

        try {
            LocalDate birthDate = LocalDate.parse(customer.customerBirthday);
            LocalDate today = LocalDate.now();
            if(Period.between(birthDate,today).getYears()<18){
                errors.rejectValue("customerBirthday","birthday18");
            }
        } catch (Exception e){
            errors.rejectValue("customerBirthday","birthday.empty");
        }

//        if(!customer.customerPhone.matches("090\\d{7}||091\\d{7}||[(]84[)][+]90\\d{7}||[(]84[)][+]91\\d{7}")){
//            errors.rejectValue("customerPhone","phone.format");
//        }
     }
}
