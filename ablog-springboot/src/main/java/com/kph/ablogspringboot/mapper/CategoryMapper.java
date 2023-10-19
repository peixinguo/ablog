package com.kph.ablogspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kph.ablogspringboot.entity.Category;
import com.kph.ablogspringboot.model.vo.CategoryBackVO;
import com.kph.ablogspringboot.model.vo.CategoryVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GuoPeiXin  create in 2023/10/19 22:13
 */
@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    List<CategoryBackVO> selectCategoryBackVO(@Param("limit") Long limit, @Param("size") Long size, @Param("keyword") String keyword);

    List<CategoryVO> selectCategoryVO();
}
