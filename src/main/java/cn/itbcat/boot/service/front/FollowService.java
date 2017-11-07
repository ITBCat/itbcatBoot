package cn.itbcat.boot.service.front;

import cn.itbcat.boot.entity.front.Fans;
import cn.itbcat.boot.entity.front.Follow;
import cn.itbcat.boot.repository.front.FansRepository;
import cn.itbcat.boot.repository.front.FollowRepository;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 860117030 on 2017/11/7.
 */
@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private FansRepository fansRepository;

    /**
     * 关注
     * @param followerId 被关注人
     * @return
     */
    public Follow save(String followerId) {
        Follow follow = new Follow();
        try {
            follow.setId(ITBC.getId());
            follow.setUserId(ITBC.getCurrUserId());
            follow.setFollowId(followerId);
            follow = followRepository.save(follow);
        }catch (Exception e){
            e.printStackTrace();
        }

        Fans fans = new Fans();
        fans.setId(ITBC.getId());
        fans.setUserId(follow.getFollowId());
        fans.setFansId(follow.getUserId());

        fansRepository.save(fans);

        return follow;
    }

    public List<Follow> findFollowByUserId(String currUserId) {
        return followRepository.findFollowByUserId(currUserId);
    }
}
