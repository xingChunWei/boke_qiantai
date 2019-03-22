package com.example.mapper;

import com.example.entity.Article;
import com.example.utils.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {


    /**
     * 查詢文章分頁
     * @param page
     * @return
     */
    List<Article> findAllArticle(Page page);



    /**
     * 统计数量
     * @param page
     * @return
     */
    int findCount(Page page);

    /**
     * 查看博客
     * @param id
     * @return
     */
    Article findOne(String id);

    /**
     *上一条
     * @param article
     * @return
     */
    Article findTop(Article article);

    /**
     * 下一条
     * @param article
     * @return
     */
    Article findBelow(Article article);
}
