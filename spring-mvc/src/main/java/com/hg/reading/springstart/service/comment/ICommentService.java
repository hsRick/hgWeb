package com.hg.reading.springstart.service.comment;

import com.hg.reading.springstart.pojo.Comment;

import java.util.List;


public interface ICommentService {

    //根据帖id查询评论表
    List<Comment> getComments(int essayid);
    //根据帖id，评论父id添加评论
    int insertComment(Comment comment);
}
