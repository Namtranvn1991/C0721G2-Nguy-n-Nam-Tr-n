package com.main.formregister.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Component
public class FormRegister implements Validator {

    @NotBlank(message = "input first name")
    String firstName;

    @NotBlank(message = "input last name")
    String lastName;

    @NotBlank(message = "input phone number")
    String phoneNumber;

    @NotNull(message = "input age")
    @Min(value = 18,message = "age 18+")
    Integer age;

    @NotBlank(message = "input email")
    String email;

    public FormRegister() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FormRegister.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FormRegister formRegister = (FormRegister) target;

        if (!formRegister.firstName.matches("[A-Z][a-z]*([ ][A-Z][a-z]*)*")){
            errors.rejectValue("firstName","first_name.invalidFormat");
        }
        if(formRegister.firstName.length()<5||formRegister.firstName.length()>45){
            errors.rejectValue("firstName","first_name.length");
        }

        if (!formRegister.lastName.matches("[A-Z][a-z]*([ ][A-Z][a-z]*)*")){
            errors.rejectValue("lastName","last_name.invalidFormat");
        }
        if(formRegister.lastName.length()<5||formRegister.lastName.length()>45){
            errors.rejectValue("lastName","last_name.length");
        }

        if (formRegister.phoneNumber.length()>11 || formRegister.phoneNumber.length()<10){
            errors.rejectValue("phoneNumber", "number.length");
        }
        if (!formRegister.phoneNumber.startsWith("0")){
            errors.rejectValue("phoneNumber", "number.startsWith");
        }
        if (!formRegister.phoneNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "number.matches");
        }

//        if(!formRegister.age.matches("\\d{1,2}")){
//            errors.rejectValue("age","age.invalidFormat");
//        }
//        try{
//            if(Integer.parseInt(formRegister.age)<18){
//                errors.rejectValue("age","age.under18");
//            }
//        } catch (Exception e){
//            errors.rejectValue("age","age.invalidFormat");
//        }
        if(!formRegister.email.matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+")){
            errors.rejectValue("email","email.invalidFormat");
        }
    }
}
