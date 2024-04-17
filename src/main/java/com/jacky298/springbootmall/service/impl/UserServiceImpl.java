package com.jacky298.springbootmall.service.impl;

import com.jacky298.springbootmall.dao.UserDao;
import com.jacky298.springbootmall.model.User;
import com.jacky298.springbootmall.model.UserRegisterRequest;
import com.jacky298.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDAO.register(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDAO.getUserById(userId);
    }
}
