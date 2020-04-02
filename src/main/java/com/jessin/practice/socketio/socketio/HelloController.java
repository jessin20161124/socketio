package com.jessin.practice.socketio.socketio;

/**
 * @Author: zexin.guo
 * @Date: 20-4-2 下午5:49
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 必须有controller。。。否则不会有嵌入tomcat启动。。。
 *
 * @Author: zexin.guo
 * @Date: 19-8-3 下午4:25
 */
@RestController
public class HelloController {

    @Resource
    private SocketIoService socketIoService;

    @RequestMapping("/hello")
    public String hello() {
        return "hello world spring boot";
    }

    /**
     * http://localhost:8080/push?userId=88&message=老哥
     * @param userId
     * @param message
     * @return
     */
    @RequestMapping("/push")
    public String pushMessage(String userId, String message) {
        PushMessage pushMessage = new PushMessage();
        pushMessage.setContent(message);
        pushMessage.setLoginUserNum(userId);
        socketIoService.pushMessageToUser(pushMessage);
        return "ok";
    }
}
