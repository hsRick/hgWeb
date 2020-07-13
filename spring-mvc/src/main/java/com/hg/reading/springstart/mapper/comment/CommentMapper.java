package com.hg.reading.springstart.mapper.comment;

import com.hg.reading.springstart.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    //根据帖id查询评论表
    List<Comment> getComments(int essayid);
    //根据帖id，评论父id添加评论
    int insertComment(Comment comment);
}
