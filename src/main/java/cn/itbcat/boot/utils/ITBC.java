package cn.itbcat.boot.utils;

import cn.itbcat.boot.entity.admin.User;
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
     * 生成ID
     * @return
     */
    public static String getId(){
        return String.valueOf(System.currentTimeMillis());
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
        if(null == null){
            return null;
        }
        return user.getUserId();
    }

}
