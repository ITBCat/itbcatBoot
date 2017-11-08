package cn.itbcat.boot.service.front;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.front.Fans;
import cn.itbcat.boot.entity.front.Follow;
import cn.itbcat.boot.entity.socket.SocketUser;
import cn.itbcat.boot.entity.socket.UserStatus;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.utils.IMManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 860117030 on 2017/11/8.
 */
@Service
public class ProfileService {

    @Autowired
    private FollowService followService;
    @Autowired
    private FansService fansService;
    @Autowired
    private UserService userService;

    public List<User> fans(String userId){
        //fans
        List<Fans> ids = fansService.findByUserId(userId);
        List<User> fans = new ArrayList<User>();
        for(Fans id : ids){
            User u = userService.get(id.getFansId());
            fans.add(u);
        }
        return fans;
    }

    public List<User> follows(String userId){
        //follows
        List<Follow> fids = followService.findFollowByUserId(userId);
        List<User> follows = new ArrayList<User>();
        for(Follow id : fids){
            User u = userService.get(id.getFollowId());
            SocketUser su = IMManager.getSocketUserByUserId(u.getUserId());
            if(su == null){
                u.setChatStatus(UserStatus.NotOnline);
            }else{
                u.setChatStatus(UserStatus.Online);
            }
            follows.add(u);
        }
        return follows;
    }
}
