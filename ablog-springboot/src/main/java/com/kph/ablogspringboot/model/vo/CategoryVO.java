package com.kph.ablogspringboot.model.vo;

import lombok.Data;

/**
 * @author GuoPeiXin  create in 2023/10/18 23:35
 */
@Data
public class CategoryVO {

    /**
     * 分类ID
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 文章数量
     */
    private Integer articleCount;
}
