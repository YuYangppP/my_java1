package domain;

import lombok.Data;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Message.java
 * @Description TODO
 * @Date 2019/12/3 11:22
 */
public class Message {
    private int id;
    private String nickname;
    private String message;
    private String mtime;
    private String ip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
