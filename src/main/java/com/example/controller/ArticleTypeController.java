package com.example.controller;


import com.example.entity.ArticleTypes;
import com.example.service.ArticleTypeService;
import com.example.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 文章
 *
 * @author XingChunWei
 * @ddata 2019-2-28 下午13:45
 */
@RestController
@RequestMapping("/articleType")
public class ArticleTypeController {

    private Logger logger = LoggerFactory.getLogger(ArticleTypeController.class);

    @Autowired
    private ArticleTypeService articleTypeService;




    /**
     * 查询文章类型
     *
     * @param
     */
    @RequestMapping("/findAllArticle")
    public JsonResult findAllArticle(ArticleTypes articleTypes) {
        articleTypes.setState(1);
        JsonResult jsonResult = new JsonResult();
       List<ArticleTypes> list =  articleTypeService.findAll(articleTypes);
       logger.info("查询所有文章分类:{}条",list.size());
       jsonResult.setData(list);
        return jsonResult;
    }



}
