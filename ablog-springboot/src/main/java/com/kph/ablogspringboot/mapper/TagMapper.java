package com.kph.ablogspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kph.ablogspringboot.entity.Tag;
import com.kph.ablogspringboot.model.vo.TagBackVO;
import com.kph.ablogspringboot.model.vo.TagOptionVO;
import com.kph.ablogspringboot.model.vo.TagVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GuoPeiXin  create in 2023/10/19 23:14
 */
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 查询后台标签列表
     *
     * @param limit   页码
     * @param size    大小
     * @param keyword 关键字
     * @return 后台标签列表
     */
    List<TagBackVO> selectTagBackVO(@Param("limit") Long limit, @Param("size") Long size, @Param("keyword") String keyword);

    /**
     * 根据标签名查询标签
     *
     * @param tagNameList 标签名列表
     * @return 标签
     */
    List<Tag> selectTagList(List<String> tagNameList);

    /**
     * 批量保存新标签
     *
     * @param newTagList 新标签
     */
    void saveBatchTag(@Param("newTagList") List<Tag> newTagList);

    /**
     * 根据文章id查询文章标签名称
     *
     * @param articleId 文章id
     * @return 文章标签名称
     */
    List<String> selectTagNameByArticleId(@Param("articleId") Integer articleId);

    /**
     * 查询文章标签列表
     *
     * @return 文章标签列表
     */
    List<TagVO> selectTagVOList();

    /**
     * 查询标签列表
     *
     * @return 标签列表
     */
    List<TagOptionVO> selectTagOptionList();
}
