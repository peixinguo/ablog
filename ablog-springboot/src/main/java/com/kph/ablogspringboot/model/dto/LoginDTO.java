package com.kph.ablogspringboot.model.dto;

/**
 * @author GuoPeiXin
 * @Date create in 2023/9/7 22:32
 */

public class LoginDTO {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
