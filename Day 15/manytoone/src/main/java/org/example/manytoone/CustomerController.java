package org.example.manytoone;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public CustomerController(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/save")
    public String saveData() {
        Customer c1 = new Customer();
        c1.setName("John Doe");
        customerRepository.save(c1);

        Order o1 = new Order();
        o1.setProduct("Laptop");
        o1.setPrice(1200);
        o1.setCustomer(c1);

        Order o2 = new Order();
        o2.setProduct("Phone");
        o2.setPrice(800);
        o2.setCustomer(c1);

        orderRepository.save(o1);
        orderRepository.save(o2);

        return "Data saved";
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
