package beam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {

    public static Connection connection;
    private static String jdbcURL = "jdbc:mysql://localhost:3306/test_module_3";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "123456781";

//    static {
//        connection = getConnection();
//
////        try {
////            Class.forName("com.mysql.jdbc.Driver");
////            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
////        } catch (SQLException |ClassNotFoundException e) {
////            e.printStackTrace();
////        }
//    }

    public static void closeCon(){
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection() {
//        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}
