package com.jacky298.springbootmall.dao;

import com.jacky298.springbootmall.model.User;
import com.jacky298.springbootmall.model.UserRegisterRequest;

public interface UserDao{
    Integer createUser(UserRegisterRequest registerRequest);
    User getUserById(Integer userId);
    User getUserByEmail(String email);
}
