package com.kph.ablogspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kph.ablogspringboot.entity.Article;
import com.kph.ablogspringboot.entity.SiteConfig;
import com.kph.ablogspringboot.mapper.ArticleMapper;
import com.kph.ablogspringboot.mapper.CategoryMapper;
import com.kph.ablogspringboot.mapper.TagMapper;
import com.kph.ablogspringboot.model.vo.BlogBackInfoVO;
import com.kph.ablogspringboot.model.vo.BlogInfoVO;
import com.kph.ablogspringboot.service.BlogInfoService;
import com.kph.ablogspringboot.service.RedisService;
import com.kph.ablogspringboot.service.SiteConfigService;
import com.kph.ablogspringboot.utils.IpUtils;
import com.kph.ablogspringboot.utils.UserAgentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

import static com.kph.ablogspringboot.constant.CommonConstant.FALSE;
import static com.kph.ablogspringboot.constant.RedisConstant.BLOG_VIEW_COUNT;
import static com.kph.ablogspringboot.constant.RedisConstant.UNIQUE_VISITOR;
import static com.kph.ablogspringboot.enums.ArticleStatusEnum.PUBLIC;

/**
 * 博客业务接口实现类
 * @author GuoPeiXin  create in 2023/10/18 23:45
 */
@Service
public class BlogInfoServiceImpl implements BlogInfoService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private RedisService redisService;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private SiteConfigService siteConfigService;

    @Override
    public void report() {
        String ipAddress = IpUtils.getIpAddress(request);
        Map<String, String> userAgentMap = UserAgentUtils.parseOsAndBrowser(request.getHeader("User-Agent"));
        String browser = userAgentMap.get("browser");
        String os = userAgentMap.get("os");
        // 生成唯一用户标识
        String uuid = ipAddress + browser + os;
        String md5 = DigestUtils.md5DigestAsHex(uuid.getBytes());
        if (!redisService.hasSetValue(UNIQUE_VISITOR,md5)){
            //访问量+1
            redisService.incr(BLOG_VIEW_COUNT, 1);
            redisService.setSet(UNIQUE_VISITOR, md5);
        }
    }

    @Override
    public BlogInfoVO getBlogInfo() {
        Long articleCount = articleMapper.selectCount(new LambdaQueryWrapper<Article>()
                .eq(Article::getStatus, PUBLIC.getStatus())
                .eq(Article::getIsDelete, FALSE));
        // 分类数量
        Long categoryCount = categoryMapper.selectCount(null);
        // 标签数量
        Long tagCount = tagMapper.selectCount(null);
        // 博客访问量
        Integer count = redisService.getObject(BLOG_VIEW_COUNT);
        String viewCount = Optional.ofNullable(count).orElse(0).toString();
        // 网站配置
        SiteConfig siteConfig = siteConfigService.getSiteConfig();
        return BlogInfoVO.builder()
                .articleCount(articleCount)
                .categoryCount(categoryCount)
                .tagCount(tagCount)
                .viewCount(viewCount)
                .siteConfig(siteConfig)
                .build();

        return null;
    }

    @Override
    public BlogBackInfoVO getBlogBackInfo() {
        return null;
    }

    @Override
    public String getAbout() {
        return null;
    }
}
