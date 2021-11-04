package common;

import model.Employee;
import model.Service;

public class Validate {
    public static boolean validateEmail(String email) {
        String regex = "^[A-Za-z]+\\w*@\\w+(\\.[A-Za-z0-9]+){1,2}||\\d{0}$";
        return email.matches(regex);
    }

    public static boolean validateEmployeeCode(String code) {
        String regex = "NV-\\d{4}";
        return code.matches(regex);
    }

    public static boolean validateName(String name) {
        String regex = "^[A-Z][a-z]+\\s([A-Z][a-z]*\\s)*[A-Z][a-z]*$";
        return name.matches(regex);
    }

    public static boolean validatePhoneNumber(String phone_number) {
        String regex = "090\\d{7}||091\\d{7}||[(]84[)][\\+]90\\d{7}||[(]84[)][\\+]91\\d{7}||\\d{0}";
        return phone_number.matches(regex);
    }

    public static boolean validateIDcard(String id_card) {
        String regex = "\\d{9}||\\d{12}||\\d{0}";
        return id_card.matches(regex);
    }

    public static boolean validateServiceName(String name) {
        String regex = "^DV-\\d{4}$";
        return name.matches(regex);
    }

    public static boolean validatePositiveDouble(double number){
        return number>=0;
    }

    public static boolean validatePositiveInt(int number){
        return number>=0;
    }


    public static boolean validateEmployee(Employee employee) throws MenuException {
        if (!validateEmail(employee.getEmail())){
            throw new MenuException("validate Email failed. xxx@xx.xx");
        }
        if (!validateEmployeeCode(employee.getEmployee_code())){
            throw new MenuException("validate Employee code failed. NV-XXXX");
        }
        if(!validateName(employee.getName())){
            throw new MenuException("validate name failed");
        }
        if(!validatePhoneNumber(employee.getPhone_number())){
            throw new MenuException("validate phone failed. 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx");
        }
        if(!validateIDcard(employee.getId_card())){
            throw new MenuException("validate Id_card failed. 9 number or 12 number");
        }
        if(!validatePositiveDouble(employee.getSalary())){
            throw new MenuException("Salary is Positive Number");
        }
        return true;
    }

    public static boolean validateService(Service service) throws MenuException {
        if(!validateServiceName(service.getName_service())) {
            throw new MenuException("validate Service name failed. DV-XXXX");
        }
        if(!validatePositiveInt(service.getArea())){
            throw new MenuException("Area is Positive Number");
        }
        if(!validatePositiveInt(service.getFloor())){
            throw new MenuException("Floor is Positive Number");
        }
        if(!validatePositiveInt(service.getMax_people())){
            throw new MenuException("Max_people is Positive Number");
        }
        if(!validatePositiveInt(service.getTypeOfRent().getIdTypeOfRent())){
            throw new MenuException("Pls input TypeOfRent");
        }
        if(!validatePositiveInt(service.getTypeOfService().getIdTypeOfService())){
            throw new MenuException("Pls input TypeOfService");
        }
        return true;
    }

}
