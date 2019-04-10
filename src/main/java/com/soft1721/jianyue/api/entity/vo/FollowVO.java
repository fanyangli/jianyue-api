package com.soft1721.jianyue.api.entity.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/4/10.
 */
@Component
@Data
public class FollowVO {
    private Integer toUId;
    private String nickname;
    private String avatar;
}

