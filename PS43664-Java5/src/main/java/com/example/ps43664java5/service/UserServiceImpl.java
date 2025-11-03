package com.example.ps43664java5.service;

import com.example.ps43664java5.dao.UserDAO;
import com.example.ps43664java5.entity.User;
import com.example.ps43664java5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    @Override
    public List<User> findAll() { return dao.findAll(); }

    @Override
    public User findById(String id) {
        Optional<User> user = dao.findById(id);
        return user.orElse(null);
    }

    @Override
    public User save(User user) { return dao.save(user); }

    @Override
    public void delete(String id) { dao.deleteById(id); }

    @Override
    public List<User> search(String keyword) { return dao.findByKeyword(keyword); }

    @Override
    public User login(String email, String password) { return dao.findByEmailAndPassword(email, password); }
}
