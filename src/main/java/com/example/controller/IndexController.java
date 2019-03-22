package com.example.controller;

import com.example.entity.Article;
import com.example.service.ArticleService;
import com.example.utils.JsonResult;
import com.example.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 博客相关页面跳转
 * @author XingChunWei
 * @data 2019/2/22
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private ArticleService articleService;
    /**
     * 首页
     * @return
     */
    @RequestMapping("/one")
    public  String index(Model model , Page page){
       JsonResult jsonResult = new JsonResult();
       jsonResult.setCount( articleService.findCount(page));
       model.addAttribute("jsonResult",jsonResult);
        return "index";
    }

    /**
     * 文章
     * @return
     */
    @RequestMapping("/all")
    public String findAll(Model model,Page page){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCount( articleService.findCount(page));
        model.addAttribute("jsonResult",jsonResult);
        model.addAttribute("aId",page.getaId());

        return "wenZhang";
    }

    /**
     * 留言
     * @return
     */
    @RequestMapping("/msgBread")
    public  String messageBread(){

        return "messageBread";
    }

    /**
     * 博主介绍
     * @return
     */
    @RequestMapping("/my")
    public  String my(){

        return "my";
    }

    

}
