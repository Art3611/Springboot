package com.example.demo.controllers;

import com.example.demo.modeldomain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    // Instancia de clase
    @Autowired
    @Qualifier("listResourceService")
    private ProductService productsService;

    @GetMapping
    public ResponseEntity<?> getProduct(){

         List<Product> products = productsService.getProducts();
         return ResponseEntity.ok(products);

    }


}
