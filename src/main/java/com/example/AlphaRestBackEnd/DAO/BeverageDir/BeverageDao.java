package com.example.AlphaRestBackEnd.DAO.BeverageDir;

import com.example.AlphaRestBackEnd.Entity.Beverage;
import com.example.AlphaRestBackEnd.Entity.User;

import java.util.List;

public interface BeverageDao {

    public List<Beverage> findAll();
    public Beverage findById(int beverageId);
    public void save (Beverage beverage);
    public void deleteById(int beverageId);

}
