package com.example.fullStackTest.dao;

import com.example.fullStackTest.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.Entity;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;

import java.util.List;
@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUsers() {

        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);

    }

    @Override
    public void registerUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User obtainUser(User user) {
        String query = "FROM User WHERE email = :email";
        List<User> list = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();

        if (list.isEmpty()) {
            return null;
        }

        String passwordHashed = list.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, user.getPassword())) {
            return list.get(0);
        }
        return null;
    }

}
