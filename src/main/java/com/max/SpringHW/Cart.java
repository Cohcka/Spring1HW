package com.max.SpringHW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> productList;
    @Autowired
    private ProductRepository pr; //test

    @PostConstruct
    private void init(){
        productList = new ArrayList<>();
    }

    public List<Product> getProductList(){
        return productList;
    }

    public void addProductInCart(Long id){
        productList.add(pr.findByID(id));
    }

    public void deleteProductFromCart(Product pr){
        //productList.remove(productList.stream().filter(product -> product.getId().equals(pr.getId())).findFirst());
        productList.removeIf(product -> product.getId().equals(pr.getId()));
    }

    public Cart(){}
}
