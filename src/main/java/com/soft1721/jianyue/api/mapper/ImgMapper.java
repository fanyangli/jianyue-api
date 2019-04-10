package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.Img;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.util.List;

/**
 * Created by Administrator on 2019/4/8.
 */
public interface ImgMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "aId", column = "a_id"),
            @Result(property = "imgUrl", column = "img_url"),
    })
    List<Img> selectImgsByAId(int aId);
}
