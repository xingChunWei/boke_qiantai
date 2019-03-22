package com.example.service.ServiceImpl;


import com.example.entity.Article;
import com.example.mapper.ArticleMapper;
import com.example.service.ArticleService;
import com.example.utils.DelHtmlUtils;
import com.example.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    /**
     * 分页
     *
     * @param page
     * @return
     */
    @Override
    public List<Article> findAllArticle(Page page) {
        page.setStart((page.getPage() - 1) * page.getLimit());
        List<Article> list = articleMapper.findAllArticle(page);
        //遍历除去Html标签
        for (Article article : list) {
            article.setContent(DelHtmlUtils.getTextFromHtml(article.getContent()));
        }
        return list;
    }


    /**
     * 查看博客文章
     *
     * @param id
     * @return
     */
    @Override
    public Article findOne(String id) {
        return articleMapper.findOne(id);
    }


    /**
     * 统计个数
     *
     * @param page
     * @return
     */
    @Override
    public int findCount(Page page) {


        return articleMapper.findCount(page);
    }

    @Override
    public Article findTop(Article article) {
        return articleMapper.findTop(article);
    }

    @Override
    public Article findBelow(Article article) {
        return articleMapper.findBelow(article);
    }
}
