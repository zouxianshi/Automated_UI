package cn.hydee.webui.aw.common.login;

import cn.hydee.webui.aw.common.constantPageObj.LoginObj;
import cn.hydee.webui.control.basecomponent.BaseComponent;
import cn.hydee.webui.control.basecomponent.ElementType;
import lombok.extern.slf4j.Slf4j;
/**0
 * @author zouxianshi
 * @description 登录AW类
 * @date 2020.7.17
 */

@Slf4j
public class LoginAW {

    public static void login(String username, String pwd) throws Exception {
        log.info("开始登陆");
        BaseComponent.findElementBy(ElementType.Xpath,LoginObj.userName_Xpath).clear();
        BaseComponent.findElementBy(ElementType.Xpath,LoginObj.userName_Xpath).sendKeys(username);
        BaseComponent.findElementBy(ElementType.Xpath,LoginObj.pwd_Xpath).sendKeys(pwd);
        BaseComponent.findElementBy(ElementType.Xpath,LoginObj.button_Xpath).click();
        BaseComponent.waitTime(5000);
    }
}


