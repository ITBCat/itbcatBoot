package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.service.socket.FriendService;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by 860117030 on 2017/10/24.
 */
@Controller
@RequestMapping(value = ITBC.SERVER_NAME_FRONT)
public class ChatController {

    @Autowired
    private FriendService friendService;

    @RequestMapping(value = "/chat",method = RequestMethod.GET)
    public String chat(Map<String,Object> data){
        data.put(ITBC.CHAT_FRIENDS,friendService.getFriends(ITBC.getCurrUserId()));
        data.put(ITBC.TEMPLATE,"chat");
        return ITBC.SYSTEM_FRONT_TEMPLATE;
    }
}
