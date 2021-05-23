package com.example.AlphaRestBackEnd.DAO.UserDir;

import com.example.AlphaRestBackEnd.Entity.User;
import com.example.AlphaRestBackEnd.SimpleTests.TestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImplementation implements UserDao{
    Logger logger = LoggerFactory.getLogger(UserDaoImplementation.class);

    private EntityManager entityManager;

    @Autowired
    public UserDaoImplementation (EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        List<User> userList = query.getResultList();
        logger.info("All users :: "+userList);
        return userList;
    }

    @Override
    public User findById(int userId) {
        User user = entityManager.find(User.class, userId);
        logger.info("User by ID :: "+user);
        return user;
    }

    @Override
    public void save(User tmpUser) {
        User user = entityManager.merge(tmpUser);
        logger.info("User was saved :: "+user);
        tmpUser.setId(user.getId());
    }

    @Override
    public void deleteById(int userId) {
        User user = entityManager.find(User.class,userId);
        entityManager.remove(user);
        logger.info("User was removed :: "+ user);
    }
}
