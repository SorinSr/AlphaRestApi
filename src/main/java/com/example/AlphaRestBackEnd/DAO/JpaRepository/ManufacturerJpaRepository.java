package com.example.AlphaRestBackEnd.DAO.JpaRepository;

import com.example.AlphaRestBackEnd.Entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Integer> {
}
