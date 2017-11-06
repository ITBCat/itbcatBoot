package cn.itbcat.boot.utils;

import cn.itbcat.boot.entity.admin.User;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;
import org.apache.shiro.SecurityUtils;


/**
 * 工具类
 * Created by 860117030 on 2017/9/7.
 */
public class ITBC {


    /**
     * product name
     */
    public static final String PRODUCT_NAME="ITBC";

    /**
     * SUPER_ADMIN
     */
    public static final String SUPER_ADMIN = "0";

    /**
     * SUPER_ADMIN
     */
    public static final String IS_ADMIN = "0";

    /**
     * SUPER_ADMIN
     */
    public static final String NOT_ADMIN = "1";

    /**
     * SUPER_ADMIN
     */
    public static final String MEMBER_ROLE = "1";

    /**
     * SUPER_ADMIN
     */
    public static final String MEMBER_ROLE_ID = "1";

    /**
     * ROLE_ADMIN
     */
    public static final String ROLE_ADMIN="admin";

    /**
     * success code ：0
     */
    public static final String SUCCESS_CODE="0";

    /**
     * error code : 1
     */
    public static final String ERROR_CODE="1";

    /***
     * system front template
     */
    public static final String SYSTEM_FRONT_TEMPLATE="front";

    /***
     * system admin template
     */
    public static final String SYSTEM_ADMIN_TEMPLATE="index";

    /**
     * template name
     */
    public static final String TEMPLATE="template";

    /**
     * profile key
     */
    public static final String PROFILER="profiler";

    /**
     * ITBCFront
     */
    public static final String ITBC_FRONT="ITBCFront";

    /**
     * ITBCFront
     */
    public static final String ITBC_ADMIN="ITBCAdmin";

    /**
     * ITBCFront
     */
    public static final String ITBC_NGINX="ITBCNginx";

    /**
     * IS_Login
     */
    public static final String IS_LOGIN="isLogin";

    /**
     * IS_Login
     */
    public static final String LANGUAGE="lang";
    /**
     * _user
     */
    public static final String _USER="_user";

    /**
     * J_user
     */
    public static final String JSON_USER="_J_user";

    /**
     * cache name
     */
    public static final String CACHE_NAME="ITBC";

    /**
     * Friends Key
     */
    public static final String CHAT_FRIENDS="friends";

    /**
     * Messages Key
     */
    public static final String CHAT_FMESSAGES="messages";

    /**
     * Defaut Pas
     */
    public static final String DEFAULT_PASSWORD="123456";

    /**
     * 删除标记（0：正常；1：删除；2：审核）
     */
    public static final String DEL_FLAG_NORMAL="0";
    public static final String DEL_FLAG_DELETE="1";
    public static final String DEL_FLAG_CHECK="2";


    /**
     * SERVER NAME FRONT
     */
    public static final String SERVER_NAME_FRONT = "/itbc";

    /**
     * SERVER NAME ADMIN
     */
    public static final String SERVER_NAME_ADMIN = "/itbc_admin";

    /**
     * 分页
     */
    public static final Integer PAGE_NUM = 0;
    public static final Integer PAGE_SIZE = 10;


    /**
     * REDIRECT_INDEX
     */
    public static final String REDIRECT_INDEX ="redirect:/f";

    /**
     * 搜索模式
     */
    public static final String SCORE_MODE_SUM = "sum"; // 权重分求和模式
    public static final Float  MIN_SCORE = 10.0F;      // 由于无相关性的分值默认为 1 ，设置权重分最小值为 10

    /**
     * 生成ID
     * @return
     */
    public static String getId(){
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 生成Long ID
     * @return
     */
    public static Long getLongId(){
        return Long.valueOf(System.currentTimeMillis());
    }

    /**
     * 获取当前用户
     */
    public static User getCurrUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取当前用户Id
     */
    public static String getCurrUserId(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(null == user){
            return null;
        }
        return user.getUserId();
    }
    /**
     * java markdown 解析器
     */

    public static String tranfer(String content){
        MutableDataSet options = new MutableDataSet();
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node document = parser.parse(content);
        return renderer.render(document);
    }

}
