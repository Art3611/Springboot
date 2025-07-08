package com.example.demo.controllers;

import com.example.demo.modeldomain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class CustomerRestController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123,"pepe","pepito","eeee"),
            new Customer(124,"pepe","pepito","eeee"),
            new Customer(125,"pepe","pepito","eeee"),
            new Customer(126,"pepe","pepito","eeee")

    ));

    @RequestMapping(method = RequestMethod.GET)
    //@GetMapping
    //@GetMapping("/clients")
    public List<Customer> getCustomers(){

        return customers;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    //@GetMapping("/{username}")
    public Customer getClient(@PathVariable  String username){
        for(Customer c : customers ){
            if(c.getUsername().equalsIgnoreCase(username)){
                return c;
            }
        }

        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    //@PostMapping
    public Customer postClient(@RequestBody Customer customer){
        customers.add(customer);
        return customer;
    }

    @RequestMapping(method = RequestMethod.PUT)
    //@PutMapping
    public Customer putClient(@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return c;
            }
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping("/{id}")
    public Customer deleteClient (@PathVariable int id){
        for(Customer c : customers){
            if(c.getID() == id){
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.PATCH)
    //@PatchMapping
    public Customer patchClient (@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getID() == customer.getID()) {
                if (customer.getName() != null) {
                    c.setName(customer.getName());
                }
                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }
                if (customer.getUsername() != null) {
                    c.setUsername(customer.getUsername());
                }
                return c;
            }
        }
        return null;
    }


}
