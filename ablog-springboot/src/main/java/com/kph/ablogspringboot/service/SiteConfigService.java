package com.kph.ablogspringboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kph.ablogspringboot.entity.SiteConfig;
import org.springframework.web.multipart.MultipartFile;

/**
 * 网站配置业务接口
 *
 * @author guopeixin
 */
public interface SiteConfigService extends IService<SiteConfig> {

    /**
     * 获取网站配置
     *
     * @return 网站配置
     */
    SiteConfig getSiteConfig();

    /**
     * 更新网站配置
     *
     * @param siteConfig 网站配置
     */
    void updateSiteConfig(SiteConfig siteConfig);

    /**
     * 上传网站配置图片
     *
     * @param file 图片
     * @return 图片路径
     */
    String uploadSiteImg(MultipartFile file);
}
