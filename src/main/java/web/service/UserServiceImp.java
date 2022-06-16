package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import web.dao.UserDAO;
import web.dao.UserDAOImp;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDAO userDAO = new UserDAOImp();

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public void editUser(int id, User user) {
        userDAO.editUser(id, user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }
}
