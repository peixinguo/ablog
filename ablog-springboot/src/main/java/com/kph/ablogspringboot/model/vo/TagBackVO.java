package com.kph.ablogspringboot.model.vo;


import lombok.Data;

import java.time.LocalDateTime;

/**
 * 标签后台VO
 *
 * @author guopeixin
 **/
@Data
public class TagBackVO {

    /**
     * 标签id
     */
    private Integer id;

    /**
     * 标签名
     */
    private String tagName;

    /**
     * 文章数量
     */
    private Integer articleCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}