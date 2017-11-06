package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.controller.ITBController;
import cn.itbcat.boot.entity.common.Result;
import cn.itbcat.boot.entity.front.ArticleSearch;
import cn.itbcat.boot.service.front.ArticleSearchService;
import cn.itbcat.boot.utils.ITBC;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 860117030 on 2017/11/3.
 */
@Controller
@RequestMapping(ITBC.SERVER_NAME_FRONT)
public class SearchController extends ITBController {

    @Autowired
    private ArticleSearchService articleSearchService;

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    @ResponseBody
    public Result search(HttpServletRequest request, Map<String,Object> data){
        String q = request.getParameter("q");
        if(StringUtils.isNotBlank(q)){
            List<ArticleSearch> list = articleSearchService.search(q);
            data.put("search",list);
        }
        return new Result(ITBC.SUCCESS_CODE,data,"");
    }

}
