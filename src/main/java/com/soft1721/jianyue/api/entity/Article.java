package com.soft1721.jianyue.api.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Data
public class Article {
    private Integer id;
    private Integer aId;
    private Integer uId;
    private String title;
    private String content;
    private String avatar;
    private String nickname;
    private Date createTime;
}
