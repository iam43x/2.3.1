package web.service;

import web.model.User;

import java.util.List;

public interface UserService {


    List<User> getAllUsers();

    boolean addUser(User user);

    void deleteUser(Long id);

    void updateUser(String firstName, String lastName, Long id);

    User getUserById(Long id);
}
