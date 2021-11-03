package repository.impl;

import model.BaseRepository;
import model.Customer;
import repository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {


    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO case_study.khach_hang (ten_khach_hang, id_loai_khach, ngay_sinh, so_cmtnd, sdt, email, dia_chi) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM case_study.khach_hang where id_khach_hang = ?;";
    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM case_study.khach_hang where status_kh = 1;";
    private static final String DELETE_CUSTOMER_SQL = "UPDATE case_study.khach_hang SET status_kh = 0 WHERE (id_khach_hang = ?);";
    private static final String UPDATE_CUSTOMER_SQL = "UPDATE case_study.khach_hang SET ten_khach_hang =?, id_loai_khach=?, ngay_sinh = ?, so_cmtnd = ?, sdt =?, email = ?, dia_chi =? where id_khach_hang =?;";


    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
        preparedStatement.setString(1,customer.getName());
        preparedStatement.setInt(2,customer.getType_customer());
        java.sql.Date birth_day = convertJavaDateToSqlDate(customer.getBirthday());
        preparedStatement.setDate(3,birth_day);
        preparedStatement.setString(4,customer.getId_card());
        preparedStatement.setString(5,customer.getPhone_number());
        preparedStatement.setString(6,customer.getEmail());
        preparedStatement.setString(7,customer.getAddress());
        preparedStatement.executeUpdate();
    }

    public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;

        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {

            preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);

            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id_customer = rs.getInt("id_khach_hang");
                String name = rs.getString("ten_khach_hang");
                int type_customer = rs.getInt("id_loai_khach");
                Date birthday = rs.getDate("ngay_sinh");
                String id_card = rs.getString("so_cmtnd");
                String phone_number = rs.getString("sdt");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                customer = new Customer(id_customer, name, birthday, id_card, phone_number, address, email, type_customer);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            BaseRepository.closeCon();
        }
        return customer;
    }


    //-----------------------
    @Override
    public List<Customer> selectAll() {
        List<Customer> customerList = new ArrayList<>();

        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CUSTOMERS);
            while (resultSet.next()) {
                int id_customer = resultSet.getInt("id_khach_hang");
                String name = resultSet.getString("ten_khach_hang");
                int type_customer = resultSet.getInt("id_loai_khach");
                Date birthday = resultSet.getDate("ngay_sinh");
                String id_card = resultSet.getString("so_cmtnd");
                String phone_number = resultSet.getString("sdt");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                Customer customer = new Customer(id_customer, name, birthday, id_card, phone_number, address, email, type_customer);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
    //-----------------------


    @Override
    public List<Customer> selectAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {

            connection = BaseRepository.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);

            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id_customer = rs.getInt("id_khach_hang");
                String name = rs.getString("ten_khach_hang");
                int type_customer = rs.getInt("id_loai_khach");
                Date birthday = rs.getDate("ngay_sinh");
                String id_card = rs.getString("so_cmtnd");
                String phone_number = rs.getString("sdt");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                Customer customer = new Customer(id_customer, name, birthday, id_card, phone_number, address, email, type_customer);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                rs.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return customerList;
    }

    @Override
    public boolean deleteCustomer(int id){
        boolean rowDeleted =false;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL);){

            preparedStatement.setString(1,id+"");
            int rowAffected = preparedStatement.executeUpdate();
            rowDeleted = rowAffected>0;
            return rowDeleted;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdate =false;

        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);
        preparedStatement.setString(1,customer.getName());
        preparedStatement.setInt(2,customer.getType_customer());
        java.sql.Date birth_day = convertJavaDateToSqlDate(customer.getBirthday());
        preparedStatement.setDate(3,birth_day);
        preparedStatement.setString(4,customer.getId_card());
        preparedStatement.setString(5,customer.getPhone_number());
        preparedStatement.setString(6,customer.getEmail());
        preparedStatement.setString(7,customer.getAddress());
        preparedStatement.setString(8,customer.getId_customer()+"");
        int rowAffected = preparedStatement.executeUpdate();
        rowUpdate = rowAffected >0;

        return rowUpdate;
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
