package com.jacky298.springbootmall.service;

import com.jacky298.springbootmall.dao.UserDao;
import com.jacky298.springbootmall.model.User;
import com.jacky298.springbootmall.model.UserDoc;
import com.jacky298.springbootmall.model.UserRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);
    User getUserById(Integer userId);
    User login(UserDoc userDoc);
}
