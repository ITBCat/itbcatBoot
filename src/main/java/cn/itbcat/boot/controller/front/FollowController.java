package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.controller.ITBController;
import cn.itbcat.boot.entity.common.Message;
import cn.itbcat.boot.entity.common.Result;
import cn.itbcat.boot.entity.front.Follow;
import cn.itbcat.boot.service.front.FollowService;
import cn.itbcat.boot.utils.ITBC;
import cn.itbcat.boot.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 860117030 on 2017/11/7.
 */
@Controller
@RequestMapping(value = ITBC.SERVER_NAME_FRONT)
public class FollowController extends ITBController{

    @Autowired
    private FollowService followService;

    /**
     *
     * @param followerId
     * userId 发起关注的人
     * followerId 被关注的人
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/follow",method = RequestMethod.POST)
    private Result follow(@RequestParam(value = "followerId") String followerId){
        if(StringUtils.isBlank(ITBC.getCurrUserId())){
            return new Result(ITBC.ERROR_CODE,null,new Message("error","not login"));
        }
        if(StringUtils.isNotBlank(followerId)){
            Follow follow = followService.save(followerId);
            if(null != follow){
                return new Result(ITBC.SUCCESS_CODE,follow,new Message());
            }
        }
        return new Result(ITBC.ERROR_CODE,null,new Message());
    }

    /**
     * 取关
     * @param followerId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/unfollow",method = RequestMethod.POST)
    private Result unfollow(@RequestParam(value = "followerId") String followerId){
        if(StringUtils.isNotBlank(followerId)){
            followService.delete(followerId);
            return new Result(ITBC.SUCCESS_CODE,null,null);
        }
        return new Result(ITBC.ERROR_CODE,null,null);
    }
}
