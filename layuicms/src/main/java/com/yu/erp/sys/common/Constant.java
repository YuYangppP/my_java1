package com.yu.erp.sys.common;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName Constant.java
 * @Description TODO
 * @Date 2020/3/21 14:14
 */
public interface Constant {

    public static final Integer OK= 200;
    public static final Integer ERROR = -1;
    /**
     * 菜单权限类型
     */
    public static final String TYPE_MENU = "menu";
    public static final String TYPE_PERMISSION = "permission";

    /**
     * 可用状态
     */
    public static final Object TYPE_AVAILABLE_TRUE = 1;
    public static final Object TYPE_AVAILABLE_FALSE = 0;

    /**
     *
     */
    public static final Integer USER_TYPE_SUPER = 0;
    public static final Integer USER_TYPE_NORMAL = 1;


    /**
     * 展开类型
     */
    public static final Integer OPEN_TRUE = 1;
    public static final Integer OPEN_FALSE = 0;

    /**
     * 默认密码
     */
    public static final String USER_DEFAULT_PWD="123456";
}
