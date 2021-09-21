package case_study.furama.model.person;

import java.util.Date;

public class Employee extends Person {
    private int employeeID;
    private String degree;
    private String position;
    private int salary;

    public static final String VOCATIONAL = "Trung cấp";
    public static final String COLLEGE = "Cao đẳng";
    public static final String UNIVERSITY = "Đại Học";
    public static final String AFTER_UNIVERSITY = "Sau Đại Học";

    public static final String RECEPTIONIST = "Lễ tân";
    public static final String WAITER = "Phục vụ";
    public static final String SPECIALIST = "Chuyên viên";
    public static final String SUPERVISOR = "Giám sát";
    public static final String MANAGER = "Quản lý";
    public static final String PRESIDENT = "Giám đốc";

    public Employee() {
    }

    public Employee(String name, Date birthday, Boolean gender, int iDCardNumber, int phoneNumber, String email, int employeeID, String degree, String position, int salary) {
        super(name, birthday, gender, iDCardNumber, phoneNumber, email);
        this.employeeID = employeeID;
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                ", employeeID=" + employeeID +
                ", degree='" + degree + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
