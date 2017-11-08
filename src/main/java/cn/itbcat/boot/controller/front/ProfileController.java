package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.controller.ITBController;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.front.Article;
import cn.itbcat.boot.entity.front.Fans;
import cn.itbcat.boot.entity.front.Follow;
import cn.itbcat.boot.service.front.ArticleService;
import cn.itbcat.boot.service.front.FansService;
import cn.itbcat.boot.service.front.FollowService;
import cn.itbcat.boot.service.front.ProfileService;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 860117030 on 2017/11/6.
 */
@Controller
@RequestMapping(ITBC.SERVER_NAME_FRONT)
public class ProfileController extends ITBController {


    @Autowired
    private FollowService followService;
    @Autowired
    private FansService fansService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/profile/{userId}",method = RequestMethod.GET)
    public String profile(@PathVariable String userId, Map<String,Object> data){
        User user = userService.get(userId);

        //fansCnt
        Integer fansCnt = fansService.count(userId);
        user.setFansCnt(fansCnt);
        user.setFans(profileService.fans(userId));

        //followCnt
        Integer followCnt = followService.count(userId);
        user.setFollowCnt(followCnt);
        user.setFollows(profileService.follows(userId));

        //ArticleCnt
        Integer articleCnt = articleService.countByUserid(userId);
        user.setArticleCnt(articleCnt);
        List<Article> articles = articleService.findByUserid(userId);
        user.setArticles(articles);

        data.put(ITBC.PROFILER,user);
        data.putAll(dataModel());
        data.put(ITBC.TEMPLATE,"profile");
        List<Follow> list = followService.findFollowByUserId(ITBC.getCurrUserId());
        data.put(ITBC.IS_FOLLOWING,false);
        for (Follow follow : list){
            if(user.getUserId().equals(follow.getFollowId())){
                data.put(ITBC.IS_FOLLOWING,true);
            }
        }

        return "front";
    }
}
