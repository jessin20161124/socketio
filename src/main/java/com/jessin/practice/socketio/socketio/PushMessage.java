package com.jessin.practice.socketio.socketio;

/**
 * @Author: zexin.guo
 * @Date: 20-4-2 下午5:28
 */
public class PushMessage {
    private String loginUserNum;

    private String content;

    public String getLoginUserNum() {
        return loginUserNum;
    }

    public void setLoginUserNum(String loginUserNum) {
        this.loginUserNum = loginUserNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}