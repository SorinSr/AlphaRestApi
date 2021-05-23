package com.example.AlphaRestBackEnd.DAO.UserDir;

import com.example.AlphaRestBackEnd.Entity.User;
import com.example.AlphaRestBackEnd.Entity.UserDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDetailDaoImplementation implements UserDetailDao{
    Logger logger = LoggerFactory.getLogger(UserDetailDaoImplementation.class);

    private EntityManager entityManager;

    @Autowired
    public UserDetailDaoImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserDetail> findAll() {
        TypedQuery<UserDetail> query = entityManager.createQuery("from UserDetail", UserDetail.class);
        List<UserDetail> userDetailList = query.getResultList();
        logger.info("All users details :: "+userDetailList);
        return userDetailList;
    }

    @Override
    public UserDetail findById(int userDetailId) {
        UserDetail userDetail = entityManager.find(UserDetail.class, userDetailId);
        logger.info("User detail by ID :: "+userDetail);
        return userDetail;
    }

    @Override
    public void save(UserDetail tmpUserDetail) {
        UserDetail userDetail = entityManager.merge(tmpUserDetail);
        logger.info("User detail was saved :: "+userDetail);
        tmpUserDetail.setId(userDetail.getId());
    }

    @Override
    public void deleteById(int userDetailId) {
        UserDetail userDetail = entityManager.find(UserDetail.class, userDetailId);
        entityManager.remove(userDetail);
        logger.info("User detail was removed :: "+ userDetail);
    }
}
