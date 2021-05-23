package com.example.AlphaRestBackEnd.DAO.ManufacturerDir;

import com.example.AlphaRestBackEnd.Entity.BeverageDetail;
import com.example.AlphaRestBackEnd.Entity.Manufacturer;

import java.util.List;

public interface ManufacturerDao {

    public List<Manufacturer> findAll();
    public Manufacturer findById(int manufacturerId);
    public void save (Manufacturer manufacturer);
    public void deleteById(int manufacturerId);

}
