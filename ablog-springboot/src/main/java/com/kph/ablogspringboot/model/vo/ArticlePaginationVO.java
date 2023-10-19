package com.kph.ablogspringboot.model.vo;

import lombok.Data;

/**
 * 文章上下篇
 *
 * @author GuoPeiXin  create in 2023/10/18 23:35
 */
@Data
public class ArticlePaginationVO {

    /**
     * 文章id
     */
    private Integer id;

    /**
     * 文章缩略图
     */
    private String articleCover;

    /**
     * 文章标题
     */
    private String articleTitle;
}
