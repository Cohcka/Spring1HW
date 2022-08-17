package com.max.SpringHW;

import com.max.SpringHW.AppConfig;
import com.sun.tools.corba.se.idl.StructEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.tools.java.ScannerInputReader;

import java.util.Scanner;

public class MainApp {
    //@Autowired
    //

    public static void main (String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService ps = context.getBean(ProductService.class);
        Cart cart = context.getBean(Cart.class);
        Scanner scanner = new Scanner(System.in);
        String x = "";
        do{
            System.out.println("Enter command ");
            x = scanner.next();
            switch (x){
                case "findAll":
                    System.out.println("All products:");
                    System.out.println(ps.findAll());
                    break;
                case "findByID":
                    System.out.println("Enter long");
                    System.out.println(ps.findByID(scanner.nextLong()));
                    break;
                case "add":
                    System.out.println("Enter params for new Product");
                    System.out.println("id");
                    long a = scanner.nextLong();
                    System.out.println("name");
                    String aa = scanner.next();
                    System.out.println("cost");
                    double aaa = scanner.nextDouble();
                    ps.add(new Product(a,aa,aaa));
                    break;
                case "deleteByID":
                    System.out.println("Enter long to delete");
                    ps.delete(scanner.nextLong());
                    break;
                case "showCart":
                    System.out.println("Show cart");
                    System.out.println(cart.getProductList());
                    break;
                case "addToCart":
                    System.out.println("Enter long to add in Cart");
                    cart.addProductInCart(scanner.nextLong());
                    break;
                case "deleteFromCart":
                    System.out.println("Enter long to delete from Cart");
                    cart.deleteProductFromCart(ps.findByID(scanner.nextLong()));
                    break;
            }
        } while(!x.equals("exit"));
        context.close();
    }
}
