package cn.itbcat.boot.service.front;

import cn.itbcat.boot.entity.front.Fans;
import cn.itbcat.boot.entity.front.Follow;
import cn.itbcat.boot.repository.front.FansRepository;
import cn.itbcat.boot.repository.front.FollowRepository;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 860117030 on 2017/11/7.
 */
@Service
public class FollowService {

    //这里的单引号不能少，否则会报错，被识别是一个对象;
    public static final String CACHE_KEY = "'CACHE_FOLLOW'";

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private FansRepository fansRepository;

    @Autowired
    private FansService fansService;

    /**
     * 关注
     * @param followerId 被关注人
     * @return
     */
    @CacheEvict(value=ITBC.CACHE_NAME,key=CACHE_KEY)
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

        fansService.save(fans);
        return follow;
    }


    @Cacheable(value= ITBC.CACHE_NAME,key="'CACHE_FOLLOW_'+#userId")
    public List<Follow> findFollowByUserId(String userId) {
        return followRepository.findFollowByUserId(userId);
    }

    public Integer count(String userId) {
        return followRepository.countByUserId(userId);
    }
    @CacheEvict(value = ITBC.CACHE_NAME,key = "'CACHE_FOLLOW_'+#followerId")
    public void delete(String followerId) {
        followRepository.deleteByUserIdAndFollowId(ITBC.getCurrUserId(),followerId);
        fansService.delete(followerId);
    }
}
