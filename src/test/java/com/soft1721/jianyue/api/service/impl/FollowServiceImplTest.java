package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Follow;
import com.soft1721.jianyue.api.entity.vo.FollowVO;
import com.soft1721.jianyue.api.service.FollowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowServiceImplTest {
    @Resource
    private FollowService followService;

    @Test
    public void getFollow() {
        Follow follow = followService.getFollow(1, 2);
        System.out.println(follow);
    }

    @Test
    public void getFollowsByUId() {
        List<FollowVO> list = followService.getFollowsByUId(1);
        System.out.println(list);
    }

   /* @Test
    public void insertFollow() {
        Follow follow = new Follow();
        follow.setFromUId(1);
        follow.setToUId(3);
        followService.insertFollow(follow);
    }*/

    /*@Test
    public void deleteFollow() {
        followService.deleteFollow(1, 30);
    }*/
}