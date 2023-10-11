package com.kph.ablogspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kph.ablogspringboot.entity.User;
import com.kph.ablogspringboot.mapper.UserMapper;
import com.kph.ablogspringboot.model.dto.LoginDTO;
import com.kph.ablogspringboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GuoPeiXin  create in 2023/9/7 23:35
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(LoginDTO login) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .select(User::getId)
                .eq(User::getUsername, login.getUsername())
                .eq(User::getPassword, ""));


        return "sample token";
    }
}
