package org.example.cartservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartServicesApplication {

  public static void main(String[] args) {
    SpringApplication.run(CartServicesApplication.class, args);
    System.out.println("Cart Service Application has been started");
  }

}
