package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void editUser(int id, User user);

    void deleteUser(int id);

    List<User> allUsers();

    User getUser(int id);

}
