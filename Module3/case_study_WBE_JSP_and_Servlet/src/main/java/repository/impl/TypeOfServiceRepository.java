package repository.impl;

import model.BaseRepository;
import model.TypeOfService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfServiceRepository {
    private static final String SELECT_ALL_TYPE_OF_SERVICE = "SELECT * FROM case_study.loai_dich_vu;";

    public List<TypeOfService> selectAllTypeOfService(){
        List<TypeOfService> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = BaseRepository.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_TYPE_OF_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_type_of_service = resultSet.getInt("id_loai_dich_vu");
                String type_of_service = resultSet.getString("ten_loai_dich_vu");
                list.add(new TypeOfService(id_type_of_service,type_of_service));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        TypeOfServiceRepository typeOfServiceRepository = new TypeOfServiceRepository();
        List<TypeOfService> list = typeOfServiceRepository.selectAllTypeOfService();
        for (TypeOfService t:list) {
            System.out.println(t);
        }
    }

}
