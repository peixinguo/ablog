package com.kph.ablogspringboot.model.vo;

import lombok.Data;

/**
 * 文章贡献统计
 * @author GuoPeiXin  create in 2023/10/18 23:38
 */
@Data
public class ArticleStatisticsVO {
    /**
     * 日期
     */
    private String date;
    /**
     * 数量
     */
    private Integer count;
}
