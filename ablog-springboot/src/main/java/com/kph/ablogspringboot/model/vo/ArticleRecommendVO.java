package com.kph.ablogspringboot.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 推荐文章
 *
 * @author GuoPeiXin  create in 2023/10/18 23:35
 **/
@Data
public class ArticleRecommendVO {

    /**
     * 文章id
     */
    private Integer id;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章缩略图
     */
    private String articleCover;

    /**
     * 发布时间
     */
    private LocalDateTime createTime;
}