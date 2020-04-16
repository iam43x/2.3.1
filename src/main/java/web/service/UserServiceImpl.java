package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public boolean addUser(User user) {

        userDao.addUser(user);
        return userDao.getAllUsers().contains(user);

    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(String firstName, String lastName, Long id) {
        userDao.updateUser(firstName, lastName, id);
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
