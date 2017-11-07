package cn.itbcat.boot.entity.common;

/**
 * Created by 860117030 on 2017/10/19.
 */
public class Result {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码 0：success 1：error
     */
    private String code;

    /**
     * 结果集
     */
    private Object data;

    /**
     * 信息
     */
    private Message message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Result(String code, Object data, Message message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
