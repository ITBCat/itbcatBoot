package cn.itbcat.boot.service.socket;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.socket.Friend;
import cn.itbcat.boot.repository.socket.FriendRepository;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 860117030 on 2017/10/27.
 */
@Service
public class FriendService {

    @Resource
    private FriendRepository friendRepository;

    @Autowired
    private UserService userService;

    public Friend get(String Id){
        return friendRepository.findOne(Id);
    }


    public List<Friend> getFriends(String userId){
        List<Friend> friends = new ArrayList<Friend>();
        if(("1").equals(userId)){
            List<User> users = userService.findAll();
            for(User user : users){
                Friend friend = new Friend();
                friend.setId(ITBC.getId());
                friend.setFriendId(userId);
                friend.setFriend(user);
                friends.add(friend);
            }
        }else{
            friends = friendRepository.findFriendByUserId(userId);

            for (Friend friend : friends){
                User f = userService.get(friend.getFriendId());
                friend.setFriend(f);
            }
        }
        return friends;
    }

    public Friend save(Friend friend) {
        return friendRepository.save(friend);
    }
}
