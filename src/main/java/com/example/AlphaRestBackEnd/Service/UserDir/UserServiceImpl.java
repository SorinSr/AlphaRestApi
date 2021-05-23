package com.example.AlphaRestBackEnd.Service.UserDir;

import com.example.AlphaRestBackEnd.DAO.UserDir.UserDaoImplementation;
import com.example.AlphaRestBackEnd.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImplementation userDaoImplementation;

    @Override
    public List<User> findAll() {
        List<User> list = userDaoImplementation.findAll();
        return list;
    }

    @Override
    public User findById(int userId) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void deleteById(int userId) {

    }
}
