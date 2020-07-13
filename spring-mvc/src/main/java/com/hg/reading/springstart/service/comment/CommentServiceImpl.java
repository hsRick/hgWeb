package com.hg.reading.springstart.service.comment;

import com.hg.reading.springstart.mapper.comment.CommentMapper;
import com.hg.reading.springstart.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getComments(int essayid) {
        return commentMapper.getComments(essayid);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }
}
