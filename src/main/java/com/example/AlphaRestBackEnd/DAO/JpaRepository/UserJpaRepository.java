package com.example.AlphaRestBackEnd.DAO.JpaRepository;

import com.example.AlphaRestBackEnd.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
}
