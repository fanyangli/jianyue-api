package com.soft1721.jianyue.api.mapper;

import com.soft1721.jianyue.api.entity.Article;
import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ArticleMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    /*@Select("SELECT a.id, a.u_id, a.title, a.content, a.create_time, b.nickname, b.avatar, c.img_url " +
            "FROM t_article AS a LEFT JOIN t_user AS b ON a.id = c.a_id " +
            "LEFT JOIN t_img AS c ON a.id = c.a_id")*/
    @Select("select a.*,b.nickname,b.avatar from t_article a left Join t_user b on a.u_id = b.id order by id desc")
    List<ArticleVO> selectAll();

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select("SELECT a.*, b.nickname, b.avatar \n" +
            "FROM t_article AS a LEFT JOIN t_user AS b ON a.u_id = b.id \n" +
            "WHERE a.id = #{aId}")
    ArticleVO getArticleById(int aId);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select("SELECT * FROM t_article WHERE u_id = #{uId}")
    List<Article> selectByuId(int uId);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "aId", column = "a_id"),
            @Result(property = "imgs", column = "img_url")
    })
    @Select("SELECT * FROM t_img WHERE a_id = #{aId}")
    List<Img> selectImgByaId(int aId);
}
