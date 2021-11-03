package common;

import model.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CheckExist {
    private static final String CHECK_EMPLOYEE_BY_CODE = "SELECT EXISTS(SELECT * FROM case_study.nhan_vien WHERE nhan_vien_code like ? and status_nv=1);";

    public static boolean checkEmployee(String code) {
        boolean exist =false;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_EMPLOYEE_BY_CODE);
            preparedStatement.setString(1,code);
            ResultSet resultSet = preparedStatement.executeQuery();
            int result = 0;
            while (resultSet.next()){
                result += resultSet.getInt(1);
            }
            exist = result>0;
            return exist;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return exist;
    }

    public static void main(String[] args) {
        System.out.println(checkEmployee("NV-0044"));
    }
}
