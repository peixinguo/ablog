package com.kph.ablogspringboot.service;

import com.kph.ablogspringboot.model.dto.LoginDTO;

/**
 * @author GuoPeiXin  create in 2023/9/7 23:22
 */
public interface LoginService {

    /**
     * 用户登录
     *
     * @param login 登录参数
     * @return token
     */
    String login(LoginDTO login);
}
