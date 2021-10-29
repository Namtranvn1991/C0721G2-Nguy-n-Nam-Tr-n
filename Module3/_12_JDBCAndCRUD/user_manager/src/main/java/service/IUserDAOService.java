package service;

import beam.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAOService {

    public List<User> selectUsersByName(String nameSearch);

    public List<User> sortByName();

    public  List<User> searchByName(String name);

    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;
}
