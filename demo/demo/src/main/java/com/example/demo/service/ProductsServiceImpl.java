package com.example.demo.service;

import com.example.demo.modeldomain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("listResourceService")
public class ProductsServiceImpl implements ProductService {


    List<Product> products = new ArrayList<>(Arrays.asList(

            new Product(1,"Zapato",88.99,10),
            new Product(2,"Tienda",55.99,16),
            new Product(3,"Boli",33.99,5),
            new Product(4,"Reloj",12.99,4)
    ));

    @Override
    public List<Product> getProducts(){

        return products;
    }


}
