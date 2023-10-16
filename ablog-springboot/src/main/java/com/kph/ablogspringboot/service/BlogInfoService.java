package com.kph.ablogspringboot.service;

import com.kph.ablogspringboot.model.vo.BlogInfoVO;

/**
 * @author GuoPeiXin  create in 2023/10/16 22:59
 */
public interface BlogInfoService {

    void report();

    /**
     * 查看博客信息
     * @return 博客信息
     */
    BlogInfoVO getBlogInfo();

    /**
     * 查看博客后台信息
     * @return 博客后台信息
     */
    BlogBackInfoVO getBlogBackInfo();
}
