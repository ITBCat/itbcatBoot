package cn.itbcat.boot.utils;

import cn.itbcat.boot.config.webConfig;
import cn.itbcat.boot.entity.User;

import javax.servlet.http.HttpServletRequest;

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
    public static final String SUPER_ADMIN = "1";

    /**
     * 删除标记（0：正常；1：删除；2：审核）
     */
    public static final String DEL_FLAG_NORMAL="0";
    public static final String DEL_FLAG_DELETE="1";
    public static final String DEL_FLAG_CHECK="2";

    /**
     * 生成ID
     * @return
     */
    public static String getId(){
        return String.valueOf(System.currentTimeMillis());
    }


}
