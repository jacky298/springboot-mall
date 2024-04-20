package com.jacky298.springbootmall.service.impl;

import com.jacky298.springbootmall.dao.UserDao;
import com.jacky298.springbootmall.model.User;
import com.jacky298.springbootmall.model.UserDoc;
import com.jacky298.springbootmall.model.UserRegisterRequest;
import com.jacky298.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDAO;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        //check if this email has been registered already.
        User user = userDAO.getUserByEmail(userRegisterRequest.getEmail());
        if(user!=null){
            log.warn("該email {} 已經被註冊",userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        
        //create an account
        return userDAO.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public User login(UserDoc userDoc) {
        User user = userDAO.getUserByEmail(userDoc.getEmail());

        if(user == null){
            log.warn("此email {}尚未註冊",userDoc.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(user.getPassword().equals(userDoc.getPassword())){
            return user;
        }else{
            log.warn("密碼不正確");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }



    }
}
