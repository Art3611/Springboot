package com.example.demo.service;

import com.example.demo.modeldomain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service("jsonResourceService")
@ConditionalOnProperty(name = "service.products", havingValue = "json")
public class ProductServiceJSONimpl implements ProductService {

    @Override
    public List<Product> getProducts() {
        List<Product>products;
        try{
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {});

            return products;

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

}
