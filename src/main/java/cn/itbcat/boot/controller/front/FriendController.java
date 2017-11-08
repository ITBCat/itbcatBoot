package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.controller.ITBController;
import cn.itbcat.boot.entity.common.Result;
import cn.itbcat.boot.entity.socket.Friend;
import cn.itbcat.boot.service.socket.FriendService;
import cn.itbcat.boot.utils.ITBC;
import cn.itbcat.boot.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 860117030 on 2017/11/8.
 */
@Controller
@RequestMapping(ITBC.SERVER_NAME_FRONT)
public class FriendController extends ITBController {

    @Autowired
    private FriendService friendService;

    @ResponseBody
    @RequestMapping(value = "/friend/{friendId}",method = RequestMethod.POST)
    private Result friend(@PathVariable String friendId){
        if(StringUtils.isNotBlank(ITBC.getCurrUserId()) && StringUtils.isNotBlank(friendId)) {
            Friend friend = new Friend();
            friend.setId(ITBC.getId());
            friend.setUserId(ITBC.getCurrUserId());
            friend.setFriendId(friendId);
            friend = friendService.save(friend);
            return new Result(ITBC.SUCCESS_CODE,friend,null);
        }

        return new Result(ITBC.ERROR_CODE,null,null);
    }

}
