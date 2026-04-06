package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository repository;
    @GetMapping("/save")
    public String saveData() {
        Customer c1 = new Customer();
        c1.setName("John Doe");
        Order o1 = new Order();
        o1.setProduct("Laptop");
        o1.setPrice(1200);
        Order o2= new Order();
        o2.setProduct("Phone");
        o2.setPrice(800);
        c1.setOrders(java.util.Arrays.asList(o1, o2));
        repository.save(c1);

        
        // Here you would typically save the order and associate it with the customer

        return "Data saved";
    }
    
    @GetMapping("/get")
    public Object getData() {
        return repository.findAll();
    }
}
 