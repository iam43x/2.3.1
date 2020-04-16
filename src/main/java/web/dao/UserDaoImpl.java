package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        List<User> users = sessionFactory.openSession().createQuery("from User").list();
        return users;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.openSession().save(user);
    }

    @Override
    public void deleteUser(Long id) {
        sessionFactory.getCurrentSession().
                createQuery("delete User u where u.id=:id").setParameter("id", id).
                executeUpdate();
    }

    @Override
    public void updateUser(String firstName, String lastName, Long id) {
        sessionFactory.getCurrentSession().createQuery(
                "update User u set u.firstName=:f,u.lastName=:l where u.id=:id").
                setParameter("f", firstName).setParameter("l", lastName).setParameter("id", id).
                executeUpdate();
    }

    @Override
    public User getUserById(Long id) {
        return sessionFactory.openSession().createQuery("select u from User u where u.id=:id", User.class).
                setParameter("id", id).getSingleResult();
    }

}