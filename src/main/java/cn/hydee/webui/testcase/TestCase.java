package cn.hydee.webui.testcase;

import cn.hydee.webui.aw.common.login.LoginAW;
import cn.hydee.webui.control.basecomponent.BaseComponent;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCase {
    @BeforeMethod
    public void setUp() {
        String url = "https://middle.test.ydjia.cn/merchant/#/login";
        BaseComponent.getUrl(url);
    }

    @Test
    public void testLogin() throws Exception {
        LoginAW.login("999999_admin","666666");
    }

    @AfterMethod
    public void tearDown(){
        BaseComponent.exit();
    }
}
