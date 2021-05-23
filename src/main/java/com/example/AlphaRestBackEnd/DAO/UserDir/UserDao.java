package com.example.AlphaRestBackEnd.DAO.UserDir;

import com.example.AlphaRestBackEnd.Entity.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();
    public User findById(int userId);
    public void save (User user);
    public void deleteById(int userId);

}
