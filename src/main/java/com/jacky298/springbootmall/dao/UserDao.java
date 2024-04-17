package com.jacky298.springbootmall.dao;

import com.jacky298.springbootmall.model.User;
import com.jacky298.springbootmall.model.UserRegisterRequest;

public interface UserDao{
    Integer register(UserRegisterRequest registerRequest);
    User getUserById(Integer userId);
}
