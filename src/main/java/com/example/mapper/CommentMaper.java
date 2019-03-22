package com.example.mapper;

import com.example.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 评论Mapper
 * @author  XingChunWei
 * @date 2019-03-22 10:44
 */
@Mapper
public interface CommentMaper {

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
