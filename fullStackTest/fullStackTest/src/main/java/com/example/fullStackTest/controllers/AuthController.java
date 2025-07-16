package com.example.fullStackTest.controllers;

import com.example.fullStackTest.dao.UserDao;
import com.example.fullStackTest.models.User;
import com.example.fullStackTest.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping( value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody User user){
        User userLogin = userDao.obtainUser(user);
       if(userLogin != null){

          String tokenJwt =  jwtUtil.create(String.valueOf(userLogin.getId()), userLogin.getEmail());
          return tokenJwt;
       }
       return "Fail";
    }


}

