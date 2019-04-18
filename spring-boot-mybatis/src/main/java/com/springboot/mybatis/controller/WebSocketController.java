package com.springboot.mybatis.controller;

import com.boot.websocket.config.WebSocketServer;
import com.springboot.mybatis.service.WebSocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WebSocketController {

    //推送数据接口
    @GetMapping("/socket/push")
    public String pushMsg(String message) {
        try {
            WebSocketServer.sendInfo(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}