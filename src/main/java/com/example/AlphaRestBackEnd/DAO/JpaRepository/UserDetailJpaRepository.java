package com.example.AlphaRestBackEnd.DAO.JpaRepository;

import com.example.AlphaRestBackEnd.Entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailJpaRepository extends JpaRepository<UserDetail, Integer> {
}
