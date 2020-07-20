package cn.hydee.webui.control.driver;

import cn.hydee.webui.control.basecomponent.Constant;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class ChromeDriverGenerator {
    private static Logger logger = LogManager.getLogger(ChromeDriverGenerator.class);

    /**
     * @author zouxianshi
     * @description 获取ChromeDriver
     * @date 2020/7/20
     * @return WebDriver
     */
    public static WebDriver getDriver(){
        logger.info("Chrome driver start begin.");
        WebDriver webDriver = null;
        Properties props = System.getProperties();
        String osName = props.getProperty("os.name");
        ChromeOptions options = new ChromeOptions();

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
//			options.addArguments(Constant.CHROME_MAX_WINDOW);
            //设置忽略并能正常打开不安全的页面
            options.setAcceptInsecureCerts(true);
            webDriver = new ChromeDriver(options);
            //自定义浏览器窗口大小
//            webDriver.manage().window().setSize(new Dimension(Constant.DIMENSION_FULLSCREEN_X,
//                    Constant.DIMENSION_FULLSCREEN_Y));
        }catch (Exception e){
            logger.error("Chrome driver start failed.", e);
        }
        logger.info("Chrome driver start end.");
        return webDriver;
    }


    /**
     * @author zouxianshi
     * @description 获退出ChromeDriver
     * @date 2020/7/20
     */
    public static void quitDriver(WebDriver driver){
        try {
            logger.info("Chrome driver quit.");
            driver.quit();
        } catch (Exception e) {
            logger.error("Chrome driver quit failed.", e);
        }
    }


}
