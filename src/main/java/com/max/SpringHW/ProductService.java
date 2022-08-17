package com.max.SpringHW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    private ProductRepository pr;

    public Product findByID(Long id){
        return pr.findByID(id);
    }

    public List<Product> findAll(){
        return pr.findAll();
    }

    public void add(Product product){
        pr.add(product);
    }

    public void delete(Long id){
        pr.deleteByID(id);
    }
}
