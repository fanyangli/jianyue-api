package com.soft1721.jianyue.api.service.impl;


import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.mapper.ImgMapper;
import com.soft1721.jianyue.api.service.ImgService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2019/4/11.
 */
@Component
@Service
public class ImgServiceImpl implements ImgService {
    @Resource
    private ImgMapper imgMapper;

    @Override
    public void insertImg(Img img) {
        imgMapper.insertImg(img);
    }
}
