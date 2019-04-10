package com.soft1721.jianyue.api.service.impl;

/**
 * Created by Administrator on 2019/4/8.
 */
import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import com.soft1721.jianyue.api.mapper.ArticleMapper;
import com.soft1721.jianyue.api.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleVO> selectAll() {
        List<ArticleVO> articles = articleMapper.selectAll();
        for (ArticleVO articleVO : articles) {
            articleVO.setImgs(articleMapper.selectImgByaId(articleVO.getId()));
        }
        return articles;
    }

    @Override
    public ArticleVO getArticleById(int aId) {
        return articleMapper.getArticleById(aId);
    }

    @Override
    public List<Img> selectImgByaId(int aId) {
        return articleMapper.selectImgByaId(aId);
    }
}
