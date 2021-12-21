package cn.crow.webui.AW.cfs;

import cn.crow.webui.AW.cfs.constantPageObj.LoginObj;
import cn.crow.webui.control.baseComponent.BaseComponent;
import lombok.extern.log4j.Log4j2;

/**0
 * @author zouxianshi
 * @description 登录AW类
 * @date 2020.7.17
 */

@Log4j2
public class Login {

    public static void login(String username, String pwd) throws Exception {
        try {
            log.info("开始登陆");
            BaseComponent.getUrl("https://ucfs.med.gzhc365.com/merchant/#/login");
            BaseComponent.findElement(LoginObj.userName_Xpath).clear();
            BaseComponent.findElement(LoginObj.userName_Xpath).sendKeys(username);
            BaseComponent.findElement(LoginObj.pwd_Xpath).sendKeys(pwd);
            BaseComponent.findElement(LoginObj.valiCode_Xpath).sendKeys("12hc#$");
            BaseComponent.findElement(LoginObj.button_Xpath).click();
            BaseComponent.findElement(LoginObj.cgr_Xpath).click();
            log.info(BaseComponent.alert());
            BaseComponent.screenShot();
        }catch (Exception e){
            log.error(e);
        }
    }

    public static void main(String[] args) throws Exception {
        login("18800000001","Yy@1234589");
    }
}


