package com.example.AlphaRestBackEnd.DAO.JpaRepository;

import com.example.AlphaRestBackEnd.Entity.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeverageJpaRepository extends JpaRepository<Beverage, Integer> {
}
