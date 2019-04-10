package com.soft1721.jianyue.api.service.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2019/4/8.
 */
import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import com.soft1721.jianyue.api.mapper.ArticleMapper;
import com.soft1721.jianyue.api.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {
    @Resource
    private ArticleMapper articleMapper;

    @Test
    public void selectAll() {
        /*List<ArticleVO> list = new ArrayList<>();
        list = articleMapper.selectAll();
        System.out.println(list);*/

        List<ArticleVO> articles = articleMapper.selectAll();
        for (ArticleVO articleVO : articles) {
            articleVO.setImgs(articleMapper.selectImgByaId(articleVO.getId()));
        }
        System.out.println(articles);
    }

    @Test
    public void getArticleById() {
        ArticleVO articleVO = articleMapper.getArticleById(2);
        List<Img> imgList = new ArrayList<>();
        imgList = articleMapper.selectImgByaId(2);
        articleVO.setImgs(imgList);
        System.out.println(articleVO);
    }

    @Test
    public void selectImgByaId() {
        List<Img> list = new ArrayList<>();
        list = articleMapper.selectImgByaId(2);
        System.out.println(list);
    }
}