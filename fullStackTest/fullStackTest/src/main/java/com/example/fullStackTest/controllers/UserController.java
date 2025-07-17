package com.example.fullStackTest.controllers;


import com.example.fullStackTest.dao.UserDao;
import com.example.fullStackTest.models.User;
import com.example.fullStackTest.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JWTUtil jwtUtil;


    @RequestMapping( value = "/user/{id}" ,method = RequestMethod.GET)
    public User getUser(@PathVariable long id){
        User user = new User();

        return user;
    }

    @RequestMapping( value = "/users", method = RequestMethod.GET)
    public List<User> getUsers(@RequestHeader(value = "Authorization")String token ){

        String userId =jwtUtil.getKey(token);
        if(userId == null){
            return new ArrayList<>();

        }



        return userDao.getUsers();
    }

    @RequestMapping( value = "/user/{id}" ,method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id){
        userDao.deleteUser(id);

    }

    @RequestMapping( value = "/users", method = RequestMethod.POST)
    public void registerUsers(@RequestBody User user){
         Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
         String hash = argon2.hash(1,1024,1,user.getPassword());
         user.setPassword(hash);
         userDao.registerUser(user);
    }



}
