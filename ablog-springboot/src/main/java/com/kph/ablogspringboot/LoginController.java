package com.kph.ablogspringboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author GuoPeiXin
 * @Description
 * @Date create in 2023/7/29 16:16
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(){
        System.out.println("success");
        return "success";
    }
}
