package com.example.ps43664java5.dao;

import com.example.ps43664java5.entity.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, String> {
    @Query("FROM User u WHERE u.email = ?1 AND u.password = ?2")
    User findByEmailAndPassword(String email, String password);

    @Query("FROM User u WHERE u.id LIKE %?1% OR u.fullname LIKE %?1%")
    List<User> findByKeyword(String keyword);
}
