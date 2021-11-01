package service.impl;

import beam.User;
import repository.IUserDAO;
import repository.impl.UserDAO;
import service.IUserDAOService;

import java.sql.SQLException;
import java.util.List;

public class UserDAOService implements IUserDAOService {
    private IUserDAO iUserDAO = new UserDAO();

    @Override
    public List<User> selectUsersByName(String nameSearch) {
        return iUserDAO.selectUsersByName(nameSearch);
    }

    @Override
    public List<User> sortByName() {
        return iUserDAO.sortByName();
    }

    @Override
    public List<User> searchByName(String name) {
        return iUserDAO.searchByName(name);
    }

    @Override
    public void insertUser(User user) throws SQLException {
        iUserDAO.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return iUserDAO.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return iUserDAO.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return iUserDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return iUserDAO.updateUser(user);
    }

    @Override
    public User getUserById(int id) {
        return iUserDAO.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        iUserDAO.insertUserStore(user);
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        iUserDAO.addUserTransaction(user,permision);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        iUserDAO.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
        iUserDAO.insertUpdateUseTransaction();
    }

    @Override
    public void addUserTransaction() {
        iUserDAO.addUserTransaction();
    }
}
