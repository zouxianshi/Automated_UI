package cn.crow.webui.testcase.cfs;

import cn.crow.webui.AW.cfs.Login;
import cn.crow.webui.AW.cfs.TemplateNew;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCase {
    @BeforeMethod
    public void setUp() {
    }

    @Test
    public void testLogin() throws Exception {
       Login.login("18800000001","Yy@123456");
       TemplateNew.newtemplate();
    }

    @AfterMethod
    public void tearDown(){
//        BaseComponent.exit();
    }
}
