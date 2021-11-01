package model;

import java.util.Date;

public class Employee extends Person {
    private int id_employee;
    private String employee_code;
    private int position;
    private int degree;
    private int department;
    private double salary;

    public Employee() {
    }

    public Employee(String employee_code, String name, Date birthday, String id_card, String phone_number, String address, String email, int position, int degree, int department, double salary) {
        super(name, birthday, id_card, phone_number, address, email);
        this.employee_code = employee_code;
        this.position = position;
        this.degree = degree;
        this.department = department;
        this.salary = salary;
    }

    public Employee(int id_employee, String employee_code, String name, Date birthday, String id_card, String phone_number, String address, String email, int position, int degree, int department, double salary) {
        super(name, birthday, id_card, phone_number, address, email);
        this.id_employee = id_employee;
        this.employee_code = employee_code;
        this.position = position;
        this.degree = degree;
        this.department = department;
        this.salary = salary;
    }

    public String getEmployee_code() {
        return employee_code;
    }

    public void setEmployee_code(String employee_code) {
        this.employee_code = employee_code;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
