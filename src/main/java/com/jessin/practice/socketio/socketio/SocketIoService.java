package com.jessin.practice.socketio.socketio;

/**
 * @Author: zexin.guo
 * @Date: 20-4-2 下午5:28
 */
public interface SocketIoService {

    //推送的事件
    public static final String PUSH_EVENT = "push_event";

    // 启动服务
    void start() throws Exception;

    // 停止服务
    void stop();

    // 推送信息
    void pushMessageToUser(PushMessage pushMessage);
}