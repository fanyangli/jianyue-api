package com.soft1721.jianyue.api.service;

/**
 * Created by Administrator on 2019/4/8.
 */
import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ArticleService {
    /*查询所有*/
    List<ArticleVO> selectAll();

    /*通过文章id查询文章信息*/
    ArticleVO getArticleById(int aId);

    List<Img> selectImgByaId(int aId);
}
