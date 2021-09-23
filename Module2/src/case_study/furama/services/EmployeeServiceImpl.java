package case_study.furama.services;

import case_study.furama.controllers.PersonInput;
import case_study.furama.model.person.Employee;
import case_study.furama.util.ReadEmployeeListAndWriteToCSV;

import java.awt.image.RasterFormatException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static ArrayList<Employee> employeesList = ReadEmployeeListAndWriteToCSV.getListEmployeeFromCSV("src\\case_study\\furama\\data\\EmployeeList.csv");
    static Scanner scanner = new Scanner(System.in);

    static {
//        employeesList.add(new Employee("Nguyen Van A", new Date(88, 0, 25), true, 12345671, 80812301, "nguyena@gmail.com", 10001, Employee.VOCATIONAL, Employee.WAITER, 6000000));
//        employeesList.add(new Employee("Nguyen Van B", new Date(95, 2, 15), true, 12345672, 80812302, "nguyenb@gmail.com", 10002, Employee.COLLEGE, Employee.RECEPTIONIST, 7000000));
//
    }

    public static ArrayList<Employee> getEmployeesList() {
        return employeesList;
    }

    public static void add(){
        System.out.println("Enter employee name ");
        String name = scanner.nextLine();

        Date birthday = PersonInput.inputBirthday();
        boolean gender = PersonInput.inputGender();
        int idCardNumber = PersonInput.inputIDCardNumber();
        int phoneNumber = PersonInput.inputPhoneNumber();
        String email = PersonInput.inputEmail();

        int employeeID = inputEmployeeID();
        String degree = inputDegree();
        String position = inputPosition();

        int salary = inputSalary();

        Employee employee = new Employee(name,birthday,gender,idCardNumber,phoneNumber,email,employeeID,degree,position,salary);
        employeesList.add(employee);
        ReadEmployeeListAndWriteToCSV.readEmployeeListAndWriteToCSV(employeesList,"src\\case_study\\furama\\data\\EmployeeList.csv",true);
    }

    public static void display(){
        int count = 1;
        for (Employee employee: employeesList) {
            System.out.println(count+"-"+employee);
            count++;
        }
    }

    public static void edit(){
        display();
        while (true){
            System.out.println("Enter employee number to edit. Enter alphabet char to return");
            String indexStr= scanner.nextLine();
            if(isStringInt(indexStr)){
                int index = Integer.parseInt(indexStr)-1;
                if (index<employeesList.size()&&index>=0){
                    editIndex(index);
                    ReadEmployeeListAndWriteToCSV.readEmployeeListAndWriteToCSV(employeesList,"src\\case_study\\furama\\data\\EmployeeList.csv",true);
                } else {
                    System.out.println(indexStr+ " isnt exist. Enter again");
                }
            } else {
                return;
            }
        }
    }

    static void editIndex(int index){
        while (true){
            System.out.println("Edit " + employeesList.get(index).toString()+"\n"+
                    "1.Name 2.Birthday 3.Gender 4.IDCardNumber 5.PhoneNumber 6.Email 7.EmployeeID 8.Degree 9.Position 10.Salary 0.Return");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    System.out.println("Enter new name");
                    employeesList.get(index).setName(scanner.nextLine());
                    employeesList.get(index).toString();
                    break;
                case "2":
                    System.out.println("Enter new birthday");
                    employeesList.get(index).setBirthday(PersonInput.inputBirthday());
                    employeesList.get(index).toString();
                    break;
                case "3":
                    System.out.println("Enter gender");
                    employeesList.get(index).setGender(PersonInput.inputGender());
                    employeesList.get(index).toString();
                    break;
                case "4":
                    System.out.println("Enter new ID Card Number");
                    employeesList.get(index).setIDCardNumber(PersonInput.inputIDCardNumber());
                    employeesList.get(index).toString();
                    break;
                case "5":
                    System.out.println("Enter new phone number");
                    employeesList.get(index).setPhoneNumber(PersonInput.inputPhoneNumber());
                    employeesList.get(index).toString();
                    break;
                case "6":
                    System.out.println("Enter new email");
                    employeesList.get(index).setEmail(scanner.nextLine());
                    employeesList.get(index).toString();
                    break;
                case "7":
                    System.out.println("Enter new employee ID");
                    employeesList.get(index).setEmployeeID(inputEmployeeID());
                    employeesList.get(index).toString();
                    break;
                case "8":
                    System.out.println("Enter new Degree");
                    employeesList.get(index).setDegree(inputDegree());
                    employeesList.get(index).toString();
                    break;
                case "9":
                    System.out.println("Enter new Position");
                    employeesList.get(index).setPosition(inputPosition());
                    employeesList.get(index).toString();
                    break;
                case "10":
                    System.out.println("Enter new salary");
                    employeesList.get(index).setSalary(inputSalary());
                    employeesList.get(index).toString();
                    break;
                default:
                    return;
            }
        }
    }


    static int inputEmployeeID() {
        while (true){
            System.out.println("Enter Employee ID");
            String employeeID = scanner.nextLine();
            if (isStringInt(employeeID)) {
                return Integer.parseInt(employeeID);
            } else {
                System.out.println("Enter again");
            }
        }
    }

    static String inputDegree() {
        while (true){
            System.out.println("Enter degree. 1/ Trung cap 2/ Cao dang 3/ Dai hoc 4/ Sau dai hoc");
            String degree = scanner.nextLine();
            switch (degree) {
                case "1":
                    return Employee.VOCATIONAL;
                case "2":
                    return Employee.COLLEGE;
                case "3":
                    return Employee.UNIVERSITY;
                case "4":
                    return Employee.AFTER_UNIVERSITY;
                default:
                    System.out.println("Enter again");
            }
        }
    }

    static String inputPosition() {
        while (true){
            System.out.println("Enter position. 1/ Le tan 2/ Phuc vu 3/ Chuyen vien 4/ Giam sat 5/ Quan ly 6/Giam doc");
            String degree = scanner.nextLine();
            switch (degree) {
                case "1":
                    return Employee.RECEPTIONIST;
                case "2":
                    return Employee.WAITER;
                case "3":
                    return Employee.SPECIALIST;
                case "4":
                    return Employee.SUPERVISOR;
                case "5":
                    return Employee.MANAGER;
                case "6":
                    return Employee.PRESIDENT;
                default:
                    System.out.println("Enter again");
            }
        }
    }

    static int inputSalary(){
        while (true){
            System.out.println("Enter salary");
            String salary = scanner.nextLine();
            if (isStringInt(salary)) {
                return Integer.parseInt(salary);
            } else {
                System.out.println("Enter again");
            }
        }
    }


    static public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
