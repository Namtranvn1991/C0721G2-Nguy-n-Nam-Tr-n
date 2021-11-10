package repository.impl;

import java.sql.SQLException;

public class Test {
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM case_study.nhan_vien where id_nhan_vien = ?;";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM case_study.nhan_vien where status_nv = 1;";


//    public Employee selectEmployee(int id) {
//        Employee employee = null;
//        try {
//            Connection connection = BaseRepository.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
//            preparedStatement.setInt(1,id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                int id_employee = resultSet.getInt("id_nhan_vien");
//                String employee_code = resultSet.getString("nhan_vien_code");
//                String name = resultSet.getString("ten_nhan_vien");
//                Date birthday = resultSet.getDate("ngay_sinh");
//                String id_card = resultSet.getString("so_cmtnd");
//                String phone_number = resultSet.getString("sdt");
//                String address = resultSet.getString("dia_chi");
//                String email = resultSet.getString("email");
//                int position = resultSet.getInt("id_vi_tri");
//                int degree = resultSet.getInt("id_trinh_do");
//                int department = resultSet.getInt("id_bo_phan");
//                double salary = resultSet.getDouble("luong");
//
//                employee = new Employee(id_employee,employee_code,name,birthday,id_card,phone_number,address,email,position,degree,department,salary);
//
//            }
//        } catch (SQLException throwables) {
//            printSQLException(throwables);
//            throwables.printStackTrace();
//        }
//        return employee;
//    }
//
//    public List<Employee> selectAllEmployees() {
//        List<Employee> employeeList = new ArrayList<>();
//        try {
//            Connection connection = BaseRepository.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                int id_employee = resultSet.getInt("id_nhan_vien");
//                String employee_code = resultSet.getString("nhan_vien_code");
//                String name = resultSet.getString("ten_nhan_vien");
//                Date birthday = resultSet.getDate("ngay_sinh");
//                String id_card = resultSet.getString("so_cmtnd");
//                String phone_number = resultSet.getString("sdt");
//                String address = resultSet.getString("dia_chi");
//                String email = resultSet.getString("email");
//                int position = resultSet.getInt("id_vi_tri");
//                int degree = resultSet.getInt("id_trinh_do");
//                int department = resultSet.getInt("id_bo_phan");
//                double salary = resultSet.getDouble("luong");
//
//                Employee employee = new Employee(id_employee,employee_code,name,birthday,id_card,phone_number,address,email,position,degree,department,salary);
//                employeeList.add(employee);
//            }
//        } catch (SQLException throwables) {
//            printSQLException(throwables);
//            throwables.printStackTrace();
//        }
//        return employeeList;
//    }
//
//    public static void main(String[] args) {
//        Test test = new Test();
//        List<Employee> employeeList = test.selectAllEmployees();
//        for (Employee employee:employeeList) {
//            System.out.println(employee);
//        }
//    }

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
