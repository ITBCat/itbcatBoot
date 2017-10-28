package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.socket.Chat;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.service.socket.ChatService;
import cn.itbcat.boot.service.socket.FriendService;
import cn.itbcat.boot.utils.ITBC;
import cn.itbcat.boot.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 860117030 on 2017/10/24.
 */
@Controller
@RequestMapping(value = ITBC.SERVER_NAME_FRONT)
public class ChatController {

    @Autowired
    private FriendService friendService;
    @Autowired
    private ChatService chatService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/chat",method = RequestMethod.GET)
    public String chat(HttpServletRequest request, Map<String, Object> data){
        String receiveId = request.getParameter("rid");
        List<Chat> chats = null;
        if(StringUtils.isNotBlank(receiveId)){
            chats = chatService.findChatByRidAndUid(receiveId,ITBC.getCurrUserId());
            User receiver = userService.get(receiveId);
            data.put("receiver",receiver);
        }
        data.put(ITBC.CHAT_FMESSAGES,chats);
        data.put(ITBC.CHAT_FRIENDS,friendService.getFriends(ITBC.getCurrUserId()));
        data.put(ITBC.TEMPLATE,"chat");
        return ITBC.SYSTEM_FRONT_TEMPLATE;
    }
}
