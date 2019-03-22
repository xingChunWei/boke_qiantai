package com.example.service;


import com.example.entity.Article;
import com.example.utils.Page;

import java.util.List;

public interface ArticleService {




    List<Article> findAllArticle(Page page);

    Article findOne(String id);

    int findCount(Page page);


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
