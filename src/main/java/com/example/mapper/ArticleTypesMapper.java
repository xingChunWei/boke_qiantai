package com.example.mapper;


import com.example.entity.ArticleTypes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 文章类型Mappper
 * @author  XingChunWei
 * @date   2019-2-28 下午13:50
 */
@Mapper
public interface ArticleTypesMapper {


 List<ArticleTypes> findAll(ArticleTypes types);

}
