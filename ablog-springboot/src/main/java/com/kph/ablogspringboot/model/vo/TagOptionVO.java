package com.kph.ablogspringboot.model.vo;

import lombok.Data;

/**
 * 标签选项VO
 * @author GuoPeiXin  create in 2023/10/18 23:38
 */
@Data
public class TagOptionVO {

    private Integer id;

    /**
     * 标签名
     */
    private String tagName;
}
