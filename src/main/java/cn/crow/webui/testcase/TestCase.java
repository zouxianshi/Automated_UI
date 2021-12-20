package cn.crow.webui.testcase;

import cn.crow.webui.AW.cfs.Login;
import cn.crow.webui.control.baseComponent.BaseComponent;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCase {
    @BeforeMethod
    public void setUp() {
        String url = "https://ucfs.med.gzhc365.com/merchant/#/login";
        BaseComponent.getUrl(url);
    }

    @Test
    public void testLogin() throws Exception {
        Login.login("999999_admin","666666");
    }

    @AfterMethod
    public void tearDown(){
        BaseComponent.exit();
    }
}
