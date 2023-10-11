package com.kph.ablogspringboot.controller;

import com.kph.ablogspringboot.model.dto.LoginDTO;
import com.kph.ablogspringboot.model.vo.Result;
import com.kph.ablogspringboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoPeiXin create in 2023/7/29 16:16
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;
    @PostMapping("/login")
    public Result<String> login(LoginDTO loginDTO){
        return Result.success(loginService.login(loginDTO));
    }
}
