package cn.itbcat.boot.entity.common;

import cn.itbcat.boot.utils.ITBC;

/**
 * Created by 860117030 on 2017/11/7.
 */
public class Message {
    private static final long serialVersionUID = 1L;

    /**
     * 消息类型
     */
    private String type;

    private String message;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message() {
    }
    public Message(String type, String message) {
        this.type = type;
        this.message = message;
    }

}
