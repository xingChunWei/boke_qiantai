package com.example.service;

import com.example.entity.Comment;

import java.util.List;

/**
 * 评论Service
 * @author XingChunWei
 * @date  2019-3-22 10:20
 */
public interface CommentService {

    /**
     * 根据文章ID查询评论
     * @param id
     * @return
     */
    List<Comment> findAll(String id);

    /**
     * 添加评论
     * @param comment
     */
    void saveComment(Comment comment);

    /**
     * 统计评论个数
     * @param id
     * @return
     */
    int countComment(String id);
}
