package cn.crow.webui.control.driver;

import cn.crow.webui.control.baseComponent.Constant;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

@Log4j2
public class ChromeDriverGenerator {

    /**
     * @author zouxianshi
     * @description 获取ChromeDriver
     * @date 2020/7/20
     * @return WebDriver
     */
    public static WebDriver getDriver(){
        log.info("Chrome driver start begin.");
//        WebDriver webDriver = null;
        Properties props = System.getProperties();
        String osName = props.getProperty("os.name");
        ChromeOptions options = new ChromeOptions();

        WebDriver webDriver = null;
        try{
            //windows操作系统
            if(osName.contains(Constant.OS_WIN)){
                System.setProperty(Constant.DRIVER_TYPE_CHROME, Constant.DRIVER_PATH_WIN);
                //linux操作系统
            }else if(osName.contains(Constant.OS_LINUX)){
                System.setProperty(Constant.DRIVER_TYPE_CHROME, Constant.DRIVER_PATH_LINUX);
            }
            //设置Chrome静默模式
			options.addArguments(Constant.CHROME_SILENCE_MODE);
            //最大化窗口
			options.addArguments(Constant.CHROME_MAX_WINDOW);
            //设置忽略并能正常打开不安全的页面
            options.setAcceptInsecureCerts(true);
            //自定义浏览器窗口大小
//            webDriver.manage().window().setSize(new Dimension(Constant.DIMENSION_FULLSCREEN_X,
//                    Constant.DIMENSION_FULLSCREEN_Y));
        }catch (Exception e){
            log.error("Chrome driver start failed.", e);
        }
        webDriver = new ChromeDriver(options);
        log.info("Chrome driver start end.");
        return webDriver;
    }


    /**
     * @author zouxianshi
     * @description 获退出ChromeDriver
     * @date 2020/7/20
     */
    public static void quitDriver(WebDriver driver){
        try {
            log.info("Chrome driver quit.");
            driver.quit();
        } catch (Exception e) {
            log.error("Chrome driver quit failed.", e);
        }
    }


}
