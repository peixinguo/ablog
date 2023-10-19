package com.kph.ablogspringboot.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

/**
 * 文章信息
 *
 * @author GuoPeiXin  create in 2023/10/18 23:35
 */
@Data
public class ArticleInfoVO {

    /**
     * 文章id
     */
    private Integer id;

    /**
     * 分类id
     */
    @JsonIgnore
    private Integer categoryId;

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
     * 是否置顶 (0否 1是)
     */
    private Integer isTop;

    /**
     * 是否推荐 (0否 1是)
     */
    private Integer isRecommend;

    /**
     * 状态 (1公开 2私密 3草稿)
     */
    private Integer status;

    /**
     * 文章分类名
     */
    private String categoryName;

    /**
     * 文章标签名
     */
    private List<String> tagNameList;
}