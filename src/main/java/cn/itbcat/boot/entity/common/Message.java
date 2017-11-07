package cn.itbcat.boot.entity.common;

/**
 * Created by 860117030 on 2017/11/7.
 */
public class Message {
    private static final long serialVersionUID = 1L;

    /**
     * 消息类型
     */
    private String type;

    private String msg;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Message() {
    }
    public Message(String type, String msg) {
        this.type = type;
        this.msg = msg;
    }
}
