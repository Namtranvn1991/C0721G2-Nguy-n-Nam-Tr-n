package repository.impl;

import model.BaseRepository;
import model.Service;
import model.TypeOfRent;
import model.TypeOfService;
import repository.IServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO case_study.nhan_vien (nhan_vien_code, ten_nhan_vien, ngay_sinh, so_cmtnd, sdt, email, dia_chi, id_vi_tri, id_trinh_do, id_bo_phan, luong) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_SERVICE_BY_ID = "SELECT * FROM case_study.dich_vu " +
            " join case_study.loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu " +
            " join case_study.kieu_thue on dich_vu.id_kieu_thue = kieu_thue.id_kieu_thue " +
            " where status_dv = 1 and id_dich_vu = ?;";


    private static final String SELECT_ALL_SERVICES = "SELECT * FROM case_study.dich_vu " +
            " join case_study.loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu " +
            " join case_study.kieu_thue on dich_vu.id_kieu_thue = kieu_thue.id_kieu_thue " +
            " where status_dv = 1;";

    private static final String DELETE_EMPLOYEE_SQL = "UPDATE case_study.nhan_vien SET status_nv = 0 WHERE (id_nhan_vien = ?);";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE case_study.nhan_vien SET nhan_vien_code =?, ten_nhan_vien=?, ngay_sinh = ?, so_cmtnd = ?, sdt =?, email = ?, dia_chi =?, id_vi_tri=?, id_trinh_do=?, id_bo_phan=?, luong=? where id_nhan_vien =?;";


    @Override
    public boolean insertService(Service service) {
        return false;
    }

    @Override
    public Service selectService(int id) {
        Service service = null;

        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
            preparedStatement.setString(1,id+"");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id_service = resultSet.getInt("id_dich_vu");
                String name = resultSet.getString("ten_dich_vu");
                int area = resultSet.getInt("dien_tich");
                int floor = resultSet.getInt("so_tang");
                int max_people = resultSet.getInt("so_nguoi_toi_da");
                String status = resultSet.getString("trang_thai");
                int id_type_of_rent = resultSet.getInt("id_kieu_thue");
                String type_of_rent = resultSet.getString("ten_kieu_thue");
                double price = Double.parseDouble(resultSet.getString("gia"));
                int id_type_of_service = resultSet.getInt("id_loai_dich_vu");
                String type_of_service = resultSet.getString("ten_loai_dich_vu");
                service = new Service(id_service,name,area,floor,max_people,status,new TypeOfRent(id_type_of_rent,type_of_rent,price),new TypeOfService(id_type_of_service,type_of_service));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return service;
    }

    @Override
    public List<Service> selectAllServices() {
        List<Service> serviceList = new ArrayList<>();

        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICES);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id_service = resultSet.getInt("id_dich_vu");
                String name = resultSet.getString("ten_dich_vu");
                int area = resultSet.getInt("dien_tich");
                int floor = resultSet.getInt("so_tang");
                int max_people = resultSet.getInt("so_nguoi_toi_da");
                String status = resultSet.getString("trang_thai");
                int id_type_of_rent = resultSet.getInt("id_kieu_thue");
                String type_of_rent = resultSet.getString("ten_kieu_thue");
                double price = Double.parseDouble(resultSet.getString("gia"));
                int id_type_of_service = resultSet.getInt("id_loai_dich_vu");
                String type_of_service = resultSet.getString("ten_loai_dich_vu");
                Service service = new Service(id_service,name,area,floor,max_people,status,new TypeOfRent(id_type_of_rent,type_of_rent,price),new TypeOfService(id_type_of_service,type_of_service));
                serviceList.add(service);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public boolean deleteService(int id) {
        return false;
    }

    @Override
    public boolean updateService(Service Service) {
        return false;
    }
}
