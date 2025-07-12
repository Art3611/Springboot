package com.example.fullStackTest.controllers;


import com.example.fullStackTest.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class UserController {

    @RequestMapping( method = RequestMethod.GET)
    public User getUser(@PathVariable int id){
        User user = new User();


        user.setName("Juan");
        user.setSurname("Pérez");
        user.setEmail("juan.perez@example.com");
        user.setPhone("123456789");
        user.setPassword("miPasswordSegura");

        return user;
    }

    @RequestMapping( value = "/userss")
    public List<User> getUsers(){

        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setId(1L);
        user1.setName("Juan");
        user1.setSurname("Pérez");
        user1.setEmail("juan.perez@example.com");
        user1.setPhone("123456789");
        user1.setPassword("miPasswordSegura");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("María");
        user2.setSurname("Gómez");
        user2.setEmail("maria.gomez@example.com");
        user2.setPhone("987654321");
        user2.setPassword("claveSegura123");

        User user3 = new User();
        user3.setId(3L);
        user3.setName("Carlos");
        user3.setSurname("Ramírez");
        user3.setEmail("carlos.ramirez@example.com");
        user3.setPhone("555123456");
        user3.setPassword("passCarlos321");

        User user4 = new User();
        user4.setId(4L);
        user4.setName("Lucía");
        user4.setSurname("Martínez");
        user4.setEmail("lucia.martinez@example.com");
        user4.setPhone("666777888");
        user4.setPassword("luciaPwd!2023");

        User user5 = new User();
        user5.setId(5L);
        user5.setName("Andrés");
        user5.setSurname("Fernández");
        user5.setEmail("andres.fernandez@example.com");
        user5.setPhone("444333222");
        user5.setPassword("andresClave456");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        return users;
    }

}
