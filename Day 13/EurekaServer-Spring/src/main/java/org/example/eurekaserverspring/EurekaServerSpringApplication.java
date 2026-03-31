package org.example.eurekaserverspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaServerSpringApplication.class, args);
    System.out.println("Eureka Server Spring Application Started");
  }

}
