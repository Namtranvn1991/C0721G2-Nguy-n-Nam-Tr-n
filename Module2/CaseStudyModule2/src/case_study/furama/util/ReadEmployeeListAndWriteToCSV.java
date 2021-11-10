package case_study.furama.util;


import case_study.furama.model.person.Employee;
import case_study.furama.model.person.Person;
import case_study.furama.services.EmployeeServiceImpl;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadEmployeeListAndWriteToCSV {
    public static void readEmployeeListAndWriteToCSV(ArrayList<Employee> employees, String pathFile){
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employees){
                bufferedWriter.write(employee.toStringToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Employee> getListEmployeeFromCSV(String pathFile){
        ArrayList<Employee> employeesList = new ArrayList<>();
        File file = new File(pathFile);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            String[] array =null;
            String[] arrayDate =null;
            while ((line=bufferedReader.readLine())!=null){
                array = line.split(",");
                String name = array[0];
                arrayDate = array[1].split("/");
                Date date = new Date(Integer.parseInt(arrayDate[2])-1990,Integer.parseInt(arrayDate[1])-1,Integer.parseInt(arrayDate[0]));
                boolean gender= true;
                if (array[2].equals("Male")){
                    gender = true;
                } else {
                    gender =false;
                }
                int iDCardNumber = Integer.parseInt(array[3]);
                int phoneNumber = Integer.parseInt(array[4]);
                String email = array[5];
                int employeeID = Integer.parseInt(array[6]);
                String degree = array[7];
                String position = array[8];
                int salary = Integer.parseInt(array[9]);

                Employee employee = new Employee(name,date,gender,iDCardNumber,phoneNumber,email,employeeID,degree,position,salary);
                employeesList.add(employee);
            }
            bufferedReader.close();
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error123");
        }
        return employeesList;
    }
}
