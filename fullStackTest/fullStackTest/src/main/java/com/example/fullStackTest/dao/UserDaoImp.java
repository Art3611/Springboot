package com.example.fullStackTest.dao;

import com.example.fullStackTest.models.User;
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

        String query = "FROM users";
        return entityManager.createQuery(query).getResultList();

    }
}
