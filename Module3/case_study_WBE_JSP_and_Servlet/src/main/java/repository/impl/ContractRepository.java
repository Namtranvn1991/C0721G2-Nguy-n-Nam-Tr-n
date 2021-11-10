package repository.impl;

import model.*;
import repository.ICustomerRepository;
import repository.IEmployeeRepository;
import repository.IServiceRepository;
import service.ICustomerService;
import service.IEmployeeService;
import service.impl.CustomerService;
import service.impl.EmployeeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractRepository {
    IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
    ICustomerRepository iCustomerRepository = new CustomerRepository();
    IServiceRepository iServiceRepository = new ServiceRepository();


    private static final String INSERT_CONTRACT_SQL = "INSERT INTO case_study.dich_vu (ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, id_kieu_thue, id_loai_dich_vu, trang_thai) VALUES (?, ?, ?, ?, ?, ?, ?);";


    private static final String SELECT_CONTRACT_BY_ID = "SELECT * FROM case_study.hop_dong where status_hd = 1 and id_hop_dong = ?;";
    private static final String SELECT_ALL_CONTRACTS = "SELECT * FROM case_study.hop_dong where status_hd = 1;";


    private static final String DELETE_CONTRACT_SQL = "UPDATE case_study.dich_vu SET status_dv = 0 WHERE (id_dich_vu = ?);";
    private static final String UPDATE_CONTRACT_SQL = "UPDATE case_study.dich_vu SET dien_tich =?, so_tang=?, so_nguoi_toi_da = ?, id_kieu_thue = ?, id_loai_dich_vu =?, trang_thai = ? where id_dich_vu =?;";



    public void insertContract(Service service) {
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_SQL);
            preparedStatement.setString(1,service.getName_service());
            preparedStatement.setString(2,service.getArea()+"");
            preparedStatement.setString(3,service.getFloor()+"");
            preparedStatement.setString(4,service.getMax_people()+"");
            preparedStatement.setString(5,service.getTypeOfRent().getIdTypeOfRent()+"");
            preparedStatement.setString(6,service.getTypeOfService().getIdTypeOfService()+"");
            preparedStatement.setString(7,service.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public Contract selectContract(int id) {
        Contract contract = null;

        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID);
            preparedStatement.setString(1,id+"");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id_contract = resultSet.getInt("id_hop_dong");
                int id_employee = resultSet.getInt("id_nhan_vien");
                int id_customer = resultSet.getInt("id_khach_hang");
                int id_service = resultSet.getInt("id_dich_vu");
                Date contract_date = resultSet.getDate("ngay_lam_hop_dong");
                Date end_date = resultSet.getDate("ngay_ket_thuc");
                double deposit = resultSet.getInt("tien_dat_coc");

                Customer customer = iCustomerRepository.selectCustomer(id_customer);
                Employee employee = iEmployeeRepository.selectEmployee(id_employee);
                Service service = iServiceRepository.selectService(id_service);

                contract = new Contract(id_contract,customer,employee,service,contract_date,end_date,deposit);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contract;
    }


    public List<Contract> selectAllContracts() {
        List<Contract> contractList = new ArrayList<>();

        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACTS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id_contract = resultSet.getInt("id_hop_dong");
                int id_employee = resultSet.getInt("id_nhan_vien");
                int id_customer = resultSet.getInt("id_khach_hang");
                int id_service = resultSet.getInt("id_dich_vu");
                Date contract_date = resultSet.getDate("ngay_lam_hop_dong");
                Date end_date = resultSet.getDate("ngay_ket_thuc");
                double deposit = resultSet.getInt("tien_dat_coc");

                Customer customer = iCustomerRepository.selectCustomer(id_customer);
                Employee employee = iEmployeeRepository.selectEmployee(id_employee);
                Service service = iServiceRepository.selectService(id_service);

                Contract contract = new Contract(id_contract,customer,employee,service,contract_date,end_date,deposit);
                contractList.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    public static void main(String[] args) {
        ContractRepository contractRepository = new ContractRepository();
        List<Contract> contractList = contractRepository.selectAllContracts();
        for (Contract contract:contractList) {
            System.out.println(contract);
        }

    }


    public void deleteContract(int id) {
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_SQL);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void updateContract(Service service) {
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT_SQL);
            preparedStatement.setString(1,service.getArea()+"");
            preparedStatement.setString(2,service.getFloor()+"");
            preparedStatement.setString(3,service.getMax_people()+"");
            preparedStatement.setString(4,service.getTypeOfRent().getIdTypeOfRent()+"");
            preparedStatement.setString(5,service.getTypeOfService().getIdTypeOfService()+"");
            preparedStatement.setString(6,service.getStatus());
            preparedStatement.setString(7,service.getId_service()+"");
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
