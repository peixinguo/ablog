package com.kph.ablogspringboot.model.vo;

import lombok.Data;

/**
 * 文章浏览量排行
 * @author GuoPeiXin  create in 2023/10/18 23:38
 */
@Data
public class ArticleRankVO {

    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 浏览量
     */
    private Integer viewCount;
}
