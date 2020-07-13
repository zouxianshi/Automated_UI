package cn.zxs.test.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestCase {
    private WebDriver driver;
    private String url = "https://www.baidu.com";
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
    public void setUp() {
            String browserDriverPath = "src\\main\\resources\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver",browserDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        driver.get(url);
        driver.findElement(By.id("kw")).clear();// 按id找到元素后，清空该元素
        driver.findElement(By.id("kw")).sendKeys("selenium");// 输入selenium
        driver.findElement(By.id("su")).click(); //点击搜索按钮
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
                Assert.fail(verificationErrorString);
        }
    }
}
