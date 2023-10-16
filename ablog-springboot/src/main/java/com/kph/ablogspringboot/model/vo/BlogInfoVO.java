package com.kph.ablogspringboot.model.vo;

import com.kph.ablogspringboot.entity.SiteConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GuoPeiXin  create in 2023/10/16 22:59
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogInfoVO {

    private Long articleCount;

    private Long categoryCount;

    private Long tagCount;

    private String viewCount;

    private SiteConfig siteConfig;

}
