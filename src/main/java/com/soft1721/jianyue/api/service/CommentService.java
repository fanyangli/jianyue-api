package com.soft1721.jianyue.api.service;

/**
 * Created by Administrator on 2019/4/8.
 */


import com.soft1721.jianyue.api.entity.Comment;
import com.soft1721.jianyue.api.entity.vo.CommentVO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CommentService {
    List<CommentVO> selectCommentsByAId(int aId);
    void addComment(Comment comment);
}
