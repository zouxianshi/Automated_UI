package cn.crow.webui.AW.cfs.constantPageObj;


/**
 * @description 登录页元素定位
 */

public class LoginObj {

    //用户名输入框
    public static final String userName_Xpath = "//*[@id=\"userName\"]";

    //密码输入框
    public static final String pwd_Xpath = "//*[@id=\"loginPassword\"]";

    //验证码输入框
    public static final String valiCode_Xpath = "//*[@id=\"valiCode\"]";

    //登录按钮
    public static final String button_Xpath = "//*[@type=\"submit\"]";

    //随访员角色
    public static final String sfy_Xpath = "//*[@id=\"root\"]//div[@class=\"role-name\"][contains(text(),\"随访员\")]";

    //超管人角色
    public static final String cgr_Xpath = "//*[@id=\"root\"]//div[@class=\"role-name\"][contains(text(),\"超管人\")]";
}
