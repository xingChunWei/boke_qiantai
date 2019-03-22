package com.example.controller;

import com.example.entity.Comment;
import com.example.service.CommentService;
import com.example.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 评论Controller
 *
 * @author XingChunWei
 * @date 2019-3-22 10:23
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CommentService commentService;

    /**
     * 根据文章Id查询评论
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult findAll(String id) {
        JsonResult jsonResult = new JsonResult();
        List<Comment> comments = commentService.findAll(id);
        if (comments.size() != 0) {
            jsonResult.setData(comments);
        }
        logger.info("ID为" + id + "的文章查询:{}条评论", comments.size());
        return jsonResult;
    }


    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/saveComment", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveComment(Comment comment) {
        JsonResult jsonResult = new JsonResult();
        comment.setUserName("邢小白的青春");
        comment.setCommentTime(new Date());
        try {
            commentService.saveComment(comment);
        } catch (Exception e) {
            e.getStackTrace();
            logger.info("评论失败！！");
            jsonResult.setCode(300);
        }
        return jsonResult;
    }

    /**
     * 根据ID查询文章评论条数
     * @param id
     * @return
     */
    @RequestMapping(value = "/countComment",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult countComment(String id){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCount(commentService.countComment(id));
        return jsonResult;
    }
}
