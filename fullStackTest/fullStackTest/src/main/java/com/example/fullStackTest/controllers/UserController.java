package com.example.fullStackTest.controllers;


import com.example.fullStackTest.dao.UserDao;
import com.example.fullStackTest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping( value = "/user/{id}" ,method = RequestMethod.GET)
    public User getUser(@PathVariable long id){
        User user = new User();

        return user;
    }

    @RequestMapping( value = "/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @RequestMapping( value = "/user/{id}" ,method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id){

        userDao.deleteUser(id);

    }

    @RequestMapping( value = "/users", method = RequestMethod.POST)
    public void registerUsers(@RequestBody User user){
         userDao.registerUser(user);
    }

}
