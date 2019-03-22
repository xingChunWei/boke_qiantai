package com.example.service.ServiceImpl;


import com.example.entity.ArticleTypes;
import com.example.mapper.ArticleTypesMapper;
import com.example.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章Service
 *
 * @author XingChunWei
 * @date 2019-2-28 下午13:49
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypesMapper articleTypesMapper;

    @Transactional

    @Override
    public List<ArticleTypes> findAll(ArticleTypes types) {
        return articleTypesMapper.findAll(types);
    }

}
