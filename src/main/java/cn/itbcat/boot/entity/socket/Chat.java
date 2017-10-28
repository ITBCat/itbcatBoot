package cn.itbcat.boot.entity.socket;

import cn.itbcat.boot.entity.admin.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 860117030 on 2017/10/25.
 */
@Entity
@Table(name = "itbc_chat")
public class Chat {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(unique = true,nullable = false,length = 20)
    private String id;

    /**
     * 发送者Id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 发送者姓名
     */
    @Column(name = "username")
    private String userName;

    /**
     * 发送内容
     */
    @Column(length = 4000)
    private String content;

    /**
     * 发送消息时间
     */
    private Date timeStamp;
    /**
     * 发送类型
     */
    private SendType sendType;

    /**
     * 消息类型
     */
    private MessageType type;

    /**
     * 接收人id（用户或群组）
     */
    private String receiveId;
    /**
     * 接收人姓名（用户或群组）
     */
    private String receiveName;

    @Transient
    private String userAvatar;

    @Transient
    private String positon;

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public SendType getSendType() {
        return sendType;
    }

    public void setSendType(SendType sendType) {
        this.sendType = sendType;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    public Chat() {
        // TODO Auto-generated constructor stub
    }

    public Chat(SendType sendType){
        this.sendType = sendType;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", timeStamp=" + timeStamp +
                ", sendType=" + sendType +
                ", receiveId='" + receiveId + '\'' +
                ", receiveName='" + receiveName + '\'' +
                '}';
    }
}
