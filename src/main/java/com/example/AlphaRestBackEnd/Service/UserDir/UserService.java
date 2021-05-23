package com.example.AlphaRestBackEnd.Service.UserDir;

import com.example.AlphaRestBackEnd.Entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User findById(int userId);
    public void save (User user);
    public void deleteById(int userId);


}
