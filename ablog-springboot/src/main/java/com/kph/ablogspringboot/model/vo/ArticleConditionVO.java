package com.kph.ablogspringboot.model.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 文章条件VO
 *
 * @author GuoPeiXin  create in 2023/10/18 23:35
 */
@Data
public class ArticleConditionVO {

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
     * 文章分类
     */
    private CategoryOptionVO category;

    /**
     * 文章标签
     */
    private List<TagOptionVO> tagVOList;

    /**
     * 发表时间
     */
    private LocalDateTime createTime;

}
