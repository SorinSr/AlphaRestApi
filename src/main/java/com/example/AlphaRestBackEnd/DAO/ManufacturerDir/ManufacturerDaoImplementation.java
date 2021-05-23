package com.example.AlphaRestBackEnd.DAO.ManufacturerDir;

import com.example.AlphaRestBackEnd.DAO.BeverageDir.BeverageDaoImplementation;
import com.example.AlphaRestBackEnd.Entity.Beverage;
import com.example.AlphaRestBackEnd.Entity.Manufacturer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ManufacturerDaoImplementation implements ManufacturerDao{
    Logger logger = LoggerFactory.getLogger(ManufacturerDaoImplementation.class);

    private EntityManager entityManager;

    @Autowired
    public ManufacturerDaoImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Manufacturer> findAll() {
        TypedQuery<Manufacturer> query = entityManager.createQuery("from Manufacturer", Manufacturer.class);
        List<Manufacturer> manufacturerList = query.getResultList();
        logger.info("All manufacturers :: "+manufacturerList);
        return manufacturerList;
    }

    @Override
    public Manufacturer findById(int manufacturerId) {
        Manufacturer manufacturer = entityManager.find(Manufacturer.class, manufacturerId);
        logger.info("Manufacturer by ID :: "+manufacturer);
        return manufacturer;
    }

    @Override
    public void save(Manufacturer tmpManufacturer) {
        Manufacturer manufacturer = entityManager.merge(tmpManufacturer);
        logger.info("Manufacturer was saved :: "+manufacturer);
        tmpManufacturer.setId(manufacturer.getId());
    }

    @Override
    public void deleteById(int manufacturerId) {
        Manufacturer manufacturer = entityManager.find(Manufacturer.class, manufacturerId);
        entityManager.remove(manufacturer);
        logger.info("Manufacturer was removed :: "+manufacturer);
    }
}
