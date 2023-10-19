package com.kph.ablogspringboot.model.vo;

import java.time.LocalDateTime;

/**
 * 后台分类VO
 * @author GuoPeiXin  create in 2023/10/19 22:15
 */
public class CategoryBackVO {
    /**
     * 分类id
     */
    private Integer id;

    /**
     * 分类名
     */
    private String categoryName;

    /**
     * 文章数量
     */
    private Integer articleCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
