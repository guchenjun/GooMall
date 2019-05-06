package com.milen.constant;

public class ResultConstant {

    /**
     *  登录注册相关常量
     */
    public static final int REGISTER_SUCCESS = 200;
    public static final String REGISTER_SUCCESS_MSG = "注册成功!";

    public static final int LOGIN_SUCCESS = 201;
    public static final String LOGIN_SUCCESS_MSG = "登录成功!";

    public static final int USERNAME_EXIST = 400;
    public static final String USERNAME_EXIST_MSG = "用户名已存在!";

    public static final int USERNAME_NOT_EXIST = 401;
    public static final String USERNAME_NOT_EXIST_MSG = "用户名不存在!";

    public static final int USERNAME_PASSWORD_FAILURE = 402;
    public static final String USERNAME_PASSWORD_FAILURE_MSG = "帐号或密码不正确!";

    /**
     *  图片上传相关常量
     */
    public static final int UPLOAD_SUCCESS = 220;
    public static final String UPLOAD_SUCCESS_MSG = "上传成功!";

    public static final int UPLOAD_ERROR = 420;
    public static final String UPLOAD_ERROR_MSG = "上传失败!";

    /**
     *  卖家相关常量
     */
    public static final int APPLY_SHOP_SUCCESS = 230;
    public static final String APPLY_SHOP_SUCCESS_MSG = "店铺申请成功，等待管理员审核!";

    public static final int APPLY_SHOP_EXIST = 430;
    public static final String APPLY_SHOP_EXIST_MSG = "店铺申请失败，当前已拥有店铺!";

    public static final int APPLY_SHOP_FAILURE = 431;
    public static final String APPLY_SHOP_FAILURE_MSG = "店铺申请失败, 请稍后再试!";


    /**
     *  后台商铺信息常量
     */
    public static final int MORE_SHOP_INFO_SUCCESS = 240;

    public static final int MORE_SHOP_INFO_FAILURE = 440;
    public static final String MORE_SHOP_INFO_FAILURE_MSG = "店铺信息获取失败，请稍后再试!";

}
