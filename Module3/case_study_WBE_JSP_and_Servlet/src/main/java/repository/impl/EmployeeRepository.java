package repository.impl;

import model.BaseRepository;
import model.Employee;
import repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO case_study.nhan_vien (nhan_vien_code, ten_nhan_vien, ngay_sinh, so_cmtnd, sdt, email, dia_chi, id_vi_tri, id_trinh_do, id_bo_phan, luong) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM case_study.nhan_vien where id_nhan_vien = ?;";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM case_study.nhan_vien where status_nv = 1;";
    private static final String DELETE_EMPLOYEE_SQL = "UPDATE case_study.nhan_vien SET status_nv = 0 WHERE (id_nhan_vien = ?);";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE case_study.nhan_vien SET nhan_vien_code =?, ten_nhan_vien=?, ngay_sinh = ?, so_cmtnd = ?, sdt =?, email = ?, dia_chi =?, id_vi_tri=?, id_trinh_do=?, id_bo_phan=?, luong=? where id_nhan_vien =?;";


    @Override
    public boolean insertEmployee(Employee employee){
        boolean rowInsert =false;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
            preparedStatement.setString(1,employee.getEmployee_code());
            preparedStatement.setString(2,employee.getName());
            java.sql.Date birth_day = convertJavaDateToSqlDate(employee.getBirthday());
            preparedStatement.setDate(3,birth_day);
            preparedStatement.setString(4,employee.getId_card());
            preparedStatement.setString(5,employee.getPhone_number());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setString(8,employee.getPosition()+"");
            preparedStatement.setString(9,employee.getDegree()+"");
            preparedStatement.setString(10,employee.getDepartment()+"");
            preparedStatement.setString(11,employee.getSalary()+"");

            int rowAffected = preparedStatement.executeUpdate();
            rowInsert = rowAffected>0;
            return rowInsert;
        } catch (SQLException throwables) {
            printSQLException(throwables);
        }
        return rowInsert;
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_employee = resultSet.getInt("id_nhan_vien");
                String employee_code = resultSet.getString("nhan_vien_code");
                String name = resultSet.getString("ten_nhan_vien");
                Date birthday = resultSet.getDate("ngay_sinh");
                String id_card = resultSet.getString("so_cmtnd");
                String phone_number = resultSet.getString("sdt");
                String address = resultSet.getString("dia_chi");
                String email = resultSet.getString("email");
                int position = resultSet.getInt("id_vi_tri");
                int degree = resultSet.getInt("id_trinh_do");
                int department = resultSet.getInt("id_bo_phan");
                double salary = resultSet.getDouble("luong");

                employee = new Employee(id_employee,employee_code,name,birthday,id_card,phone_number,address,email,position,degree,department,salary);

            }
        } catch (SQLException throwables) {
            printSQLException(throwables);
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_employee = resultSet.getInt("id_nhan_vien");
                String employee_code = resultSet.getString("nhan_vien_code");
                String name = resultSet.getString("ten_nhan_vien");
                Date birthday = resultSet.getDate("ngay_sinh");
                String id_card = resultSet.getString("so_cmtnd");
                String phone_number = resultSet.getString("sdt");
                String address = resultSet.getString("dia_chi");
                String email = resultSet.getString("email");
                int position = resultSet.getInt("id_vi_tri");
                int degree = resultSet.getInt("id_trinh_do");
                int department = resultSet.getInt("id_bo_phan");
                double salary = resultSet.getDouble("luong");

                Employee employee = new Employee(id_employee,employee_code,name,birthday,id_card,phone_number,address,email,position,degree,department,salary);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            printSQLException(throwables);
            throwables.printStackTrace();
        }
        return employeeList;
    }


    @Override
    public boolean deleteEmployee(int id) {
        boolean rowDelete = false;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);

            preparedStatement.setString(1,id+"");
            int rowAffected = preparedStatement.executeUpdate();
            rowDelete = rowAffected>0;
            return rowDelete;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }


    @Override
    public boolean updateEmployee(Employee employee){
        boolean rowUpdate =false;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);
            preparedStatement.setString(1,employee.getEmployee_code());
            preparedStatement.setString(2,employee.getName());
            java.sql.Date birth_day = convertJavaDateToSqlDate(employee.getBirthday());
            preparedStatement.setDate(3,birth_day);
            preparedStatement.setString(4,employee.getId_card());
            preparedStatement.setString(5,employee.getPhone_number());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setString(8,employee.getPosition()+"");
            preparedStatement.setString(9,employee.getDegree()+"");
            preparedStatement.setString(10,employee.getDepartment()+"");
            preparedStatement.setString(11,employee.getSalary()+"");
            preparedStatement.setString(12,employee.getId_employee()+"");

            int rowAffected = preparedStatement.executeUpdate();
            rowUpdate = rowAffected >0;
            return rowUpdate;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;
    }

    public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
