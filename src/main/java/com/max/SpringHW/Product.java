package com.max.SpringHW;

public class Product {
    private long id;
    private String name;
    private double cost;

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Product (long id, String name, double cost){
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
}
