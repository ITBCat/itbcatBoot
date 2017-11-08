package cn.itbcat.boot.service.front;

import cn.itbcat.boot.entity.front.Fans;
import cn.itbcat.boot.repository.front.FansRepository;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Seven on 2017/11/7.
 */
@Service
public class FansService {

    //这里的单引号不能少，否则会报错，被识别是一个对象;
    public static final String CACHE_KEY = "'CACHE_FANS'";

    @Autowired
    private FansRepository fansRepository;

    public Integer count(String userId) {
       return fansRepository.countByUserId(userId);
    }

    /**
     * 根据Id查询Fans
     * @param userId
     * @return
     */
    @Cacheable(value= ITBC.CACHE_NAME,key="'CACHE_FANS_'+#userId")
    public List<Fans> findByUserId(String userId) {
        return fansRepository.findByUserId(userId);
    }

    /**
     * 保存，并更新缓存
     * @param fans
     */
    @CacheEvict(value=ITBC.CACHE_NAME,key=CACHE_KEY)
    public void save(Fans fans) {
        fansRepository.save(fans);
    }

    @CacheEvict(value = ITBC.CACHE_NAME,key = "'CACHE_FANS_'+#followerId")
    public void delete(String followerId) {
        fansRepository.deleteByUserIdAndFansId(followerId,ITBC.getCurrUserId());
    }
}
