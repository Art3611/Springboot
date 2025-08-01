package com.myapp.invoicing.service;

import com.myapp.invoicing.entity.User;
import com.myapp.invoicing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}