package com.example.AlphaRestBackEnd.DAO.BeverageDir;

import com.example.AlphaRestBackEnd.Entity.BeverageDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BeverageDetailDaoImplementation implements BeverageDetailDao{
    Logger logger = LoggerFactory.getLogger(BeverageDetailDaoImplementation.class);

    private EntityManager entityManager;

    @Autowired
    public BeverageDetailDaoImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<BeverageDetail> findAll() {
        TypedQuery<BeverageDetail> query = entityManager.createQuery("from BeverageDetail",BeverageDetail.class);
        List<BeverageDetail> beverageDetail = query.getResultList();
        logger.info("All beverage details :: "+beverageDetail);
        return beverageDetail;
    }

    @Override
    public BeverageDetail findById(int beverageDetailId) {
        BeverageDetail beverageDetail = entityManager.find(BeverageDetail.class, beverageDetailId);
        logger.info("Beverage detail by Id :: "+beverageDetail);
        return beverageDetail;
    }

    @Override
    public void save(BeverageDetail tmpBeverageDetail) {
        BeverageDetail beverageDetail = entityManager.merge(tmpBeverageDetail);
        logger.info("Beverage details was saved :: "+beverageDetail);
        tmpBeverageDetail.setId(beverageDetail.getId());
    }

    @Override
    public void deleteById(int beverageDetailId) {
        BeverageDetail beverageDetail = entityManager.find(BeverageDetail.class, beverageDetailId);
        entityManager.remove(beverageDetail);
        logger.info("Beverage was removed :: "+beverageDetail);
    }
}
