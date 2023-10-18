package com.kph.ablogspringboot.model.vo;

import lombok.Data;

/**
 * 用户浏览
 * @author GuoPeiXin  create in 2023/10/18 23:38
 */
@Data
public class UserViewVO {

    private String date;

    private Integer pv;

    private Integer uv;
}
