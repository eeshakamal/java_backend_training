package com.example.demo.services;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    // Simulated user store — replace with DB in production
    private static final Map<String, String> USERS = new HashMap<>();

    static {
        USERS.put("admin", "admin123");
        USERS.put("ravi", "12345");
    }

    public boolean authenticate(String username, String password) {
        return USERS.containsKey(username) && USERS.get(username).equals(password);
    }
}
