package com.example.ps43664java5.service;

import com.example.ps43664java5.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(String id);
    User save(User user);
    void delete(String id);
    List<User> search(String keyword);
    User login(String email, String password);
}
