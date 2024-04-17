package com.jacky298.springbootmall.dao.impl;

import com.jacky298.springbootmall.dao.UserDao;
import com.jacky298.springbootmall.model.User;
import com.jacky298.springbootmall.model.UserRegisterRequest;
import com.jacky298.springbootmall.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer register(UserRegisterRequest registerRequest) {
        String sql = "INSERT INTO user(email, password, created_date, last_modified_date) "+
                "VALUES (:email, :password, :createdDate, :lastModifiedDate) ";


        Map<String, Object> map = new HashMap<>();
        map.put("email", registerRequest.getEmail());
        map.put("password", registerRequest.getPassword());

        Date now = new Date();

        map.put("createdDate", now);
        map.put("lastModifiedDate", now);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map),keyHolder);

        int userId = keyHolder.getKey().intValue();

        return userId;
    }

    @Override
    public User getUserById(Integer userId) {
        String sql = "SELECT  user_id,email,password,created_date,last_modified_date " +
                "FROM user " +
                "WHERE user_id = :userId";

        Map<String, Object> map = new HashMap<>();

        map.put("userId", userId);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if(!userList.isEmpty()){
            return userList.get(0);
        }else{
            return null;
        }

    }
}