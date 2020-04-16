package web.dao;

import web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(String firstName, String lastName, Long id);

    User getUserById(Long id);

}
