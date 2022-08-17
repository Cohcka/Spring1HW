package com.max.SpringHW;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(Arrays.asList(
                new Product(1,"Bread",58.2),
                new Product(2,"Milk",80.11),
                new Product(3,"Eggs",30),
                new Product(4,"Chocolate",150.50),
                new Product(5,"Croissant",99.0)
                ));
    }

    public Product findByID(long id){
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException());
    }

    public List<Product> findAll(){
        return products;
    }

    public void add(Product product){
        products.add(product);
    }

    public void deleteByID(Long id){
        products.remove(findByID(id));
    }
}
