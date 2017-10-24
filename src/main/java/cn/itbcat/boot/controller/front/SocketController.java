package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.front.BaseMessage;
import cn.itbcat.boot.entity.front.ChatMessage;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.utils.DateUtils;
import cn.itbcat.boot.utils.ITBC;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Date;

/**
 * Created by 860117030 on 2017/10/24.
 */
@Controller
public class SocketController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private UserService userService;

    @MessageMapping("/chat")
    public void chat(String message) {
        BaseMessage baseMessage = JSON.parseObject(message, BaseMessage.class);
        this.send(baseMessage);
    }
    private void send(BaseMessage message) {
        message.setDate(new Date());
        ChatMessage chatMessage = createMessage(message.getSender(), message.getContent());
        template.convertAndSendToUser(message.getReceiver(), "/topic/chat", JSON.toJSONString(chatMessage));
    }

    private ChatMessage createMessage(String userId, String message) {
        ChatMessage chatMessage = new ChatMessage();
        User user = userService.get(userId);
        chatMessage.setUsername(user.getUserId());

        chatMessage.setAvatar(user.getAvatar());
        chatMessage.setNickname(user.getUsername());
        chatMessage.setContent(message);
        chatMessage.setSendTime(DateUtils.chatToday(new Date()));
        return chatMessage;
    }
}
