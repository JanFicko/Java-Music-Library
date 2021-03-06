package cz.muni.fi.pa165.music_library.dao.implementations;

import cz.muni.fi.pa165.music_library.dao.interfaces.UserDao;
import cz.muni.fi.pa165.music_library.data.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * @author Klara Minsterova
 */

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void createUser(User user) {
        em.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUserById(Long userId) {
        return em.find(User.class, userId);
    }

    @Override
    public User getUserByName(String username) {
        try {
            return em.createQuery("select u from User u where username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            return em.createQuery("select u from User u where email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public void deleteUser(User user) {
        if (user == null) throw new IllegalArgumentException();
        em.remove(em.find(User.class, user.getUserId()));
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }
}
