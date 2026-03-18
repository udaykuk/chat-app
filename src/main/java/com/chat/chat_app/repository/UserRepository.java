package com.chat.chat_app.repository;

import com.chat.chat_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);
    List<User> findByStatusTrue();
}
