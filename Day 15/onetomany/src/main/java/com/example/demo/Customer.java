package com.example.demo;


import jakarta.persistence.*;

import java.util.List;
import jakarta.persistence.Entity; // Ensure this import is correct
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity // <--- This MUST be here
public class Customer {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private java.util.List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

 