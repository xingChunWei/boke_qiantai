package com.example.controller;

import com.example.entity.Article;
import com.example.service.ArticleService;
import com.example.utils.JsonResult;
import com.example.utils.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ArticleService articleService;


    /**
     * 查看博客文章
     *
     * @return
     */
    @RequestMapping("/wzck")
    public String findOne(Model model, String id) {
        Article article = articleService.findOne(id);
        model.addAttribute("article", article);
        return "wz_ck";
    }

    /**
     * 查詢所有文章
     *
     * @return
     */
    @RequestMapping("/wzglList")
    @ResponseBody
    public JsonResult findAll(Page page) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCount(articleService.findCount(page));
        List<Article> list = articleService.findAllArticle(page);
        jsonResult.setData(list);
        return jsonResult;
    }


    /**
     * 查询文章
     *
     * @param article
     * @return
     */
    @RequestMapping("/findOne")
    public JsonResult findOne1(Article article) {
        JsonResult jsonResult = new JsonResult();
        Article article1 = articleService.findOne(article.getId());
        return jsonResult;
    }

    /**
     * 查询上一条
     *
     * @param article
     * @return
     */
    @RequestMapping("/top")
    @ResponseBody
    public JsonResult findTop(Article article) {
        JsonResult jsonResult = new JsonResult();
        List<Article> articles = new ArrayList<>();
        articles.add(articleService.findTop(article));
        if (articles.size() != 0) {
            jsonResult.setData(articles);
        } else {
            jsonResult.setCode(300);
        }

        return jsonResult;
    }

    /**
     * 下一条
     *
     * @param article
     * @return
     */
    @RequestMapping("/below")
    @ResponseBody
    public JsonResult findBelow(Article article) {
        JsonResult jsonResult = new JsonResult();
        List<Article> articles = new ArrayList<>();
        articles.add(articleService.findBelow(article));
        if (articles.size() != 0) {
            jsonResult.setData(articles);
        } else {
            jsonResult.setCode(300);
        }

        return jsonResult;
    }
}
