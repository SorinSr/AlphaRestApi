package com.example.AlphaRestBackEnd.DAO.UserDir;

import com.example.AlphaRestBackEnd.Entity.User;
import com.example.AlphaRestBackEnd.Entity.UserDetail;

import java.util.List;

public interface UserDetailDao {

    public List<UserDetail> findAll();
    public UserDetail findById(int userDetailId);
    public void save (UserDetail userDetail);
    public void deleteById(int userDetailId);

}
