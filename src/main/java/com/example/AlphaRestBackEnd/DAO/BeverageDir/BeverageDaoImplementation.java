package com.example.AlphaRestBackEnd.DAO.BeverageDir;

import com.example.AlphaRestBackEnd.Entity.Beverage;
import com.example.AlphaRestBackEnd.SimpleTests.TestController;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BeverageDaoImplementation implements BeverageDao{
    Logger logger = LoggerFactory.getLogger(BeverageDaoImplementation.class);

    private EntityManager entityManager;

    @Autowired
    public BeverageDaoImplementation (EntityManager entityManager){
        this.entityManager=entityManager;
    }


    @Override
    public List<Beverage> findAll() {
        TypedQuery<Beverage> query = entityManager.createQuery("from Beverage", Beverage.class);
        List<Beverage> beverageList = query.getResultList();
        logger.info("All users :: "+beverageList);
        return beverageList;
    }

    @Override
    public Beverage findById(int beverageId) {
        Beverage beverage = entityManager.find(Beverage.class, beverageId);
        logger.info("User by ID :: "+beverage);
        return beverage;
    }

    @Override
    public void save(Beverage tmpBeverage) {
        Beverage beverage = entityManager.merge(tmpBeverage);
        logger.info("Beverage was saved :: "+beverage);
        tmpBeverage.setId(beverage.getId());
    }

    @Override
    public void deleteById(int beverageId) {
        Beverage beverage = entityManager.find(Beverage.class, beverageId);
        entityManager.remove(beverage);
        logger.info("Beverage was removed :: "+beverage);
    }
}
