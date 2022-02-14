package cn.crow.webui.AW.cfs;

import cn.crow.webui.AW.cfs.constantPageObj.LoginObj;
import cn.crow.webui.control.baseComponent.BaseComponent;
import lombok.extern.log4j.Log4j2;

/**
 * 0
 *
 * @author zouxianshi
 * @description 登录AW类
 * @date 2020.7.17
 */

@Log4j2
public class Login {
    static BaseComponent baseComponent = new BaseComponent();

    public static void login(String username, String pwd) {
        try {
            log.info("开始登陆");
            baseComponent.getUrl("https://ucfs.med.gzhc365.com/merchant/#/login");
            baseComponent.findElement(LoginObj.userName_Xpath).clear();
            baseComponent.findElement(LoginObj.userName_Xpath).sendKeys(username);
            baseComponent.findElement(LoginObj.pwd_Xpath).sendKeys(pwd);
            baseComponent.findElement(LoginObj.valiCode_Xpath).sendKeys("12hc#$");
            baseComponent.findElement(LoginObj.button_Xpath).click();
            baseComponent.findElement(LoginObj.cgr_Xpath).click();
            log.info(baseComponent.alert());
            baseComponent.screenShot();
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static void main(String[] args) throws Exception {
        login("18774388904", "Silvercrow@6133");
    }
}


