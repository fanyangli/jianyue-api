package com.soft1721.jianyue.api.entity.vo;

import com.soft1721.jianyue.api.entity.Img;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/4/8.
 */
@Component
@Data
public class ArticleVO {
    private Integer id;
    private Integer uId;
    private String title;
    private String content;
    private Date createTime;
    private String nickname;
    private String avatar;
    private List<Img> imgs;

    public Integer getuId() {
        return uId;
    }
}
