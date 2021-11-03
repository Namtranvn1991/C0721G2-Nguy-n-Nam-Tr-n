package repository.impl;

import model.BaseRepository;
import model.TypeOfRent;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfRentRepository {
    private static final String SELECT_ALL_TYPE_OF_RENT = "SELECT * FROM case_study.kieu_thue;";

    public List<TypeOfRent> selectAllTypeOfRent(){
        List<TypeOfRent> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = BaseRepository.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_TYPE_OF_RENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_type_of_rent = resultSet.getInt("id_kieu_thue");
                String type_of_rent = resultSet.getString("ten_kieu_thue");
                int price = resultSet.getInt("gia");
                list.add(new TypeOfRent(id_type_of_rent,type_of_rent,price));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
