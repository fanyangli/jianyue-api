package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.Follow;
import com.soft1721.jianyue.api.entity.vo.FollowVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/4/10.
 */
@Component
public interface FollowService {
    Follow getFollow(int fromUId, int toUId);

    List<FollowVO> getFollowsByUId(int fromUId);

    void insertFollow(Follow follow);

    void deleteFollow(int fromUId, int toUId);
}
