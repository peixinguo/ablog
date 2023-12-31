package com.kph.ablogspringboot.model.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 文章VO
 *
 * @author GuoPeiXin  create in 2023/10/18 23:35
 */
@Data
public class ArticleVO {

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

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章类型 (1原创 2转载 3翻译)
     */
    private Integer articleType;

    /**
     * 浏览量
     */
    private Integer viewCount;

    /**
     * 点赞量
     */
    private Integer likeCount;

    /**
     * 文章分类
     */
    private CategoryOptionVO category;

    /**
     * 文章标签
     */
    private List<TagOptionVO> tagVOList;

    /**
     * 上一篇文章
     */
    private ArticlePaginationVO lastArticle;

    /**
     * 下一篇文章
     */
    private ArticlePaginationVO nextArticle;

    /**
     * 发表时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}