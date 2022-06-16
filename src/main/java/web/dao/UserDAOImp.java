package web.dao;


import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void editUser(int id, User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }
}
