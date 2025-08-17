package com.tipical.todo.security;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Cliente {

    Long id;
    String nombre;
    String email;

}
public Cliente(Long id, String nombre, String email){
    this.id = id;
    this.nombre = nombre;
    this.email = email;
}

List<T> clientes = new ArrayList<>();
clientes.add(Cliente c1 = new Cliente(1,"pepe1","spdsdispd"));
clientes.add(Cliente c2 = new Cliente(2,"pepe2","swpdsdispd"));
clientes.add(Cliente c3 = new Cliente(3,"pepe3","spdffdsdispd"));


public <T> mostrarClientes(List<T> lista){

    lista.stream.filter(c -> c.getEmail().contains("pepe")).forEach(c -> System.out.println(c.getNombre()));

}

}