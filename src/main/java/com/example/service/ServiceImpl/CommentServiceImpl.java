package com.example.service.ServiceImpl;

import com.example.entity.Comment;
import com.example.mapper.CommentMaper;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论ServiceImpl
 *
 * @author XingChunWei
 * @date 2019-3-22 10:35
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMaper commentMaper;

    @Override
    public List<Comment> findAll(String id) {
        return commentMaper.findAll(id);
    }

    @Override
    public void saveComment(Comment comment) {


        commentMaper.saveComment(comment);
    }

    @Override
    public int countComment(String id) {
        return commentMaper.countComment(id);
    }
}
