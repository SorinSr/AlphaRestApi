package com.example.AlphaRestBackEnd.DAO.BeverageDir;

import com.example.AlphaRestBackEnd.Entity.Beverage;
import com.example.AlphaRestBackEnd.Entity.BeverageDetail;

import java.util.List;

public interface BeverageDetailDao {

    public List<BeverageDetail> findAll();
    public BeverageDetail findById(int beverageDetailId);
    public void save (BeverageDetail beverageDetail);
    public void deleteById(int beverageDetailId);
}
