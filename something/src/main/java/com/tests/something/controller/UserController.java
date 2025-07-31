package com.tests.something.controller;

import com.tests.something.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @PostMapping
    public String validateUser(@RequestBody User user) {
        if (user.getName().isEmpty()) return "el nombre no puede estar vacio";
        if (user.getAge() < 18) return "tienes que ser mayor de edad";
        if (user.getMail().isEmpty()) return "el correo no puede estar vacio";

        return "Usuario correcto";
    }
}
