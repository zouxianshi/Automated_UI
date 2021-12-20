package cn.crow.webui.AW.cfs;

import cn.crow.webui.AW.cfs.constantPageObj.LoginObj;
import cn.crow.webui.control.baseComponent.BaseComponent;
import cn.crow.webui.control.baseComponent.ET;
import lombok.extern.log4j.Log4j2;

/**0
 * @author zouxianshi
 * @description 登录AW类
 * @date 2020.7.17
 */

@Log4j2
public class Login {

    public static void login(String username, String pwd) throws Exception {
        log.info("开始登陆");
        BaseComponent.getUrl("https://ucfs.med.gzhc365.com/merchant/#/login");
        BaseComponent.findElementBy(LoginObj.userName_Xpath).clear();
        BaseComponent.findElementBy(LoginObj.userName_Xpath).sendKeys(username);
        BaseComponent.findElementBy(LoginObj.pwd_Xpath).sendKeys(pwd);
        BaseComponent.findElementBy(LoginObj.valiCode_Xpath).sendKeys("12hc#$");
        BaseComponent.findElementBy(LoginObj.button_Xpath).click();
        BaseComponent.findElementBy(LoginObj.cgr_Xpath).click();
        BaseComponent.waitTime(5000);
    }

    public static void main(String[] args) throws Exception {
        login("18800000001","Yy@123456");
    }
}


