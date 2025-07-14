package com.example.fullStackTest.dao;

import com.example.fullStackTest.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    void deleteUser(Long id);

    void registerUser(User user);
}
