package cn.crow.webui.control.baseComponent;

import cn.crow.webui.control.driver.ChromeDriverGenerator;
import junit.framework.Assert;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author : zouxianshi
 * @date : 2020年7月18日
 * @description: 基础控件管理类
 */
@Log4j2
public class BaseComponent extends Thread {

    static WebDriver driver = ChromeDriverGenerator.getDriver();
    private ET type;
    private String value;
    WebElement webElement;

    public void tv(ET type, String value) {
        this.type = type;
        this.value = value;
    }

    public void setWebElement(WebElement element){
        this.webElement = element;
    }

    /**
     * @return : Boolean ret: true or false
     * @description : 获取url
     * @author : zouxianshi
     * @date : 2020年7月18日
     * @parameter : String url
     */

    public void getUrl(String url) {
        try {
            driver.manage().window().maximize();
            driver.get(url);
        } catch (Exception e) {
            String errStr = String.format("Get url: %s failed.", url);
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @return :
     * @description : 等待指定时间长度
     * @author : zouxianshi
     * @date : 2020/7/18
     * @parameter : int time
     */

    public void waitTime(long time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    /**
     * @return : WebElement element, null
     * @throws : Exception
     * @description : 查找元素
     * @author : zouxianshi
     * @date : 2020/7/18
     * @parameter : ElementType type 元素类型 String value 元素查找表达式
     */


    public WebElement findElement(String value) throws Exception {
        ET[] etarr = ET.values();
        for (ET et : etarr) {
            BaseComponent baseComponent = new BaseComponent();
            baseComponent.tv(et, value);
            Thread thread = new Thread(baseComponent);
            thread.start();
        }
        return webElement;
    }

    public void run() {
        final By by = getBy(type, value);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.ELEMENT_WAIT_TIME));
        WebElement element = wait.until((ExpectedCondition<WebElement>) driver -> driver.findElement(by));
        if (element != null){
            setWebElement(element);
        }
    }


    public WebElement findElementBy(ET type, String value) throws Exception {
        WebElement element;
        // 获取查找元素by对象
        final By by = getBy(type, value);
        try {
            // 查找元素显式等待指定时间，内部类实现查找元素并等待
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.ELEMENT_WAIT_TIME));
            element = wait.until((ExpectedCondition<WebElement>) driver -> driver.findElement(by));

        } catch (Exception e) {
            String errStr = String.format("Find element by type %s failed. %s ", type, value);
            log.error(errStr, e);
            throw e;
        }
        return element;
    }

    /**
     * @return : List<WebElement>, 元素列表or null
     * @description : 查找元素列表
     * @author : zouxianshi
     * @date : 2020/7/18
     * @parameter : ElementType type 元素类型 String value 元素查找表达式
     */

    public List<WebElement> findElementsBy(ET type, String value) {
        List<WebElement> elements;
        // 获取查找元素by对象
        final By by = getBy(type, value);
        try {
            // 查找元素显式等待指定时间，内部类实现查找元素并等待
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.ELEMENT_WAIT_TIME));
            elements = wait.until((ExpectedCondition<List<WebElement>>) driver -> driver.findElements(by));
        } catch (Exception e) {
            String errStr = String.format("Find elements by type %s failed. %s ", type, value);
            log.error(errStr, e);
            throw e;
        }
        return elements;
    }

    /**
     * @return : Boolean ret
     * @description : 等待元素展示
     * @author : zouxianshi
     * @date : 2020/7/18
     * @parameter : final WebElement element
     */

    private Boolean waitElementDisplayed(final WebElement element) {
        Boolean ret = false;
        if (element == null)
            return ret;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.ELEMENT_WAIT_TIME));
            ret = wait.until((ExpectedCondition<Boolean>) driver -> element.isDisplayed());

        } catch (Exception e) {
            String errStr = String.format("Wait element % displayed failed.", element);
            log.error(errStr, e);
        }
        return ret;
    }

    /**
     * @return : By
     * @description : 获取by对象
     * @author : zouxianshi
     * @date : 2020/7/18
     * @parameter : ElementType type 元素类型 String value 元素查找表达式
     */

    private By getBy(ET type, String value) {
        By by = null;
        switch (type) {
            case Id:
                by = By.id(value);
                break;
            case Name:
                by = By.name(value);
                break;
            case ClassName:
                by = By.className(value);
                break;
            case Xpath:
                by = By.xpath(value);
                break;
            case CssSelector:
                by = By.cssSelector(value);
                break;
            case TagName:
                by = By.tagName(value);
                break;
            case LinkText:
                by = By.linkText(value);
                break;
            case PartialLinkText:
                by = By.partialLinkText(value);
                break;
        }
        return by;
    }

    /**
     * @return
     * @description : 模拟输入值
     * @author : zouxianshi
     * @date : 2020/7/18
     * @parameter : WebElement element String keys
     */

    public void sendKeys(WebElement element, String keys) {
        try {
            element.sendKeys(keys);
        } catch (Exception e) {
            String errStr = String.format("Send element keys %s failed.", keys);
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @return :
     * @description : 模拟输入值键盘操作
     * @author : zouxianshi
     * @date : 2020/7/18
     * @parameter : WebElement element Keys
     */

    public void sendKeys(WebElement element, Keys keys) {
        try {
            element.sendKeys(keys);
        } catch (Exception e) {
            String errStr = String.format("Send element keys %s failed.", keys.name());
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @return :
     * @throws Exception
     * @description : 单击
     * @author : zouxianshi
     * @date : 2020/7/18
     * @parameter : WebElement element
     */

    public void click(WebElement element) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.ELEMENT_WAIT_TIME));
            // 等待元素显示
            if (waitElementDisplayed(element)) {
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
            }
        } catch (Exception e) {
            String errStr = String.format("Click element %s failed.", element.toString());
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @return :
     * @throws Exception
     * @description : 选择select
     * @author : zouxianshi
     * @date : 2020/7/18
     * @parameter : WebElement element
     */

    public void select(final WebElement element) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.ELEMENT_WAIT_TIME));
            // 等待元素显示
            if (waitElementDisplayed(element)) {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                wait.until(ExpectedConditions.elementToBeSelected(element));
                element.click();
            }
        } catch (Exception e) {
            String errStr = String.format("Select element %s failed.", element.toString());
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @return :
     * @throws Exception
     * @description : 检查元素中是否包含指定数据
     * @author : zouxianshi
     * @date : 2020/7/18
     * @parameter : WebElement element, String value
     */

    public void checkElementValue(WebElement element, String text) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.ELEMENT_WAIT_TIME));
            // 等待元素显示
            if (waitElementDisplayed(element)) {
                wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
            }
        } catch (Exception e) {
            String errStr = String.format("Check element %s value %s failed.", element.toString(), text);
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @return :
     * @throws Exception
     * @description : 检查元素是否不可见
     * @author : zouxianshi
     * @date : 2020/7/18
     * @parameter : WebElement element
     */

    public void checkElementNotDiplay(final WebElement element) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.ELEMENT_WAIT_TIME));
            // 等待元素不显示
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return !element.isDisplayed();
                }
            });
        } catch (Exception e) {
            String errStr = String.format("Check element %s not display failed.", element.toString());
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @throws Exception
     * @description : 切换frame
     * @author : zouxianshi
     * @date : 2020/7/18
     * @parameter : WebElement element
     */

    public void switchToFrame(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch (Exception e) {
            String errStr = String.format("Switch element : %s failed.", element.toString());
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @description : 清除输入框
     * @author : zouxianshi
     * @date : 2020年7月20日
     * @parameter : WebElement element
     * @throws: Exception
     */

    public void clearElement(WebElement element) throws Exception {
        try {
            element.clear();
        } catch (Exception e) {
            String errStr = String.format("Clear element : %s failed.", element.toString());
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @description : 切换frame，回到上级frame
     * @author : zouxianshi
     * @date : 2020年7月20日
     * @parameter : WebElement element
     * @throws: Exception
     */

    public void switchToDefault() throws Exception {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            log.error("Switch currunt frame to default failed.", e);
            throw e;
        }
    }

    /**
     * @return :
     * @description : 跳转页面
     * @author : zouxianshi
     * @date : 2020年8月9日
     * @parameter : String url 跳转的目标url
     */

    public void navigateToUrl(String url) throws Exception {
        try {
            driver.navigate().to(url);
        } catch (Exception e) {
            String errStr = String.format("Navigate to url %s failed.", url);
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @throws Exception
     * @description : 移动到指定元素
     * @author : zouxianshi
     * @date : 2020年7月20日
     * @parameter : WebElement element
     */

    public void actionMoveToElement(WebElement element) throws Exception {
        try {
            // 等待元素显示
            if (waitElementDisplayed(element)) {
                Actions action = new Actions(driver);
                action.moveToElement(element);
            }
        } catch (Exception e) {
            String errStr = String.format("Move to element %s failed.", element.toString());
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @throws Exception
     * @description : 鼠标双击指定元素
     * @author : zouxianshi
     * @date : 2020年7月20日
     * @parameter : WebElement element
     */

    public void actionDoubleClick(WebElement element) throws Exception {
        try {
            // 等待元素显示
            if (waitElementDisplayed(element)) {
                Actions action = new Actions(driver);
                action.doubleClick(element).perform();
            }
        } catch (Exception e) {
            String errStr = String.format("Double click element %s failed.", element.toString());
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @throws Exception
     * @description : 通过js移动到指定元素
     * @author : zouxianshi
     * @date : 2020年7月20日
     * @parameter : WebElement element
     */

    public void moveToElementByJs(WebElement element) throws Exception {
        try {
            // 等待元素显示
            if (waitElementDisplayed(element)) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true)", element);
            }
        } catch (Exception e) {
            String errStr = String.format("Move to element %s by js failed.", element.toString());
            log.error(errStr, e);
            throw e;
        }
    }

    /**
     * @return :
     * @description : 设置driver
     * @author : zouxianshi
     * @date : 2020年7月20日
     * @parameter : WebDriver webdriver
     */

    public void setDriver(WebDriver webdriver) {
        driver = webdriver;
    }

    /**
     * @param type            ElementType type 元素类型 String value 元素查找表达式
     * @param value,          type的value
     * @param maxWaitTimeout： 等待加载的最大时间（秒），如果超过还未加载完就报等待超时
     * @description: 等待元素消失，常用于等待加载框或者等待框消失
     * @author: zouxianshi
     * @data: 2019-01-07
     */


    public void waitForLoadingEleDisappear(ET type, String value, long maxWaitTimeout) {
        // 获取查找元素by对象
        waitTime(1000);
        final By by = getBy(type, value);
        List<WebElement> eleList = driver.findElements(by);

        while (eleList.size() > 0 && maxWaitTimeout > 0) {
            try {
                Thread.sleep(1000);
                log.info("休眠1s");
            } catch (InterruptedException e) {
                e.printStackTrace();
                Assert.fail("休眠1s异常");
            }
            maxWaitTimeout = maxWaitTimeout - 1;
            eleList = driver.findElements(by);
        }

        waitTime(Constant.ELEMENT_WAIT_TIME);
        if (eleList.size() == 0) {
            log.info("加载框加载完成");
        } else {
            Assert.fail("等待加载框加载超时，仍未加载完成");
        }


    }

    /**
     * @param type   ElementType type 元素类型 String value 元素查找表达式
     * @param value, type的value
     * @description: 判断元素是否存在
     * @author zouxiansh
     * @date 2020/7/18
     */

    public Boolean checkElementIsExisted(ET type, String value) throws Exception {
        // 获取查找元素by对象
        waitTime(1);
        final By by = getBy(type, value);
        List<WebElement> elements = driver.findElements(by);

        waitTime(Constant.ELEMENT_WAIT_TIME);

        return elements.size() != 0;

    }


    /**
     * @param element     定位元素,tagName下拉列表标签
     * @param visibleText 传入的参数
     * @date 2019-03-06
     * @description 根据传入参数选择非select标签类下拉框
     */
    public void selectByVisibleText(WebElement element, String visibleText, String tagName) throws Exception {
        List<WebElement> elementList = element.findElements(By.tagName(tagName));
        //增加等待元素展示
        log.info("elementList.size():" + elementList.size());
        for (WebElement webElement : elementList) {
            if (visibleText != null && webElement.getText().contains(visibleText)) {
                webElement.click();
                break;
            }
        }
    }

    /**
     * @author: zouxianshi
     * @description: 回车操作
     */
    public void actionEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    /**
     * @Description:
     * @Author: zouxianshi
     * @Date: 2021/12/21 17:05
     * @Param []
     * @Return void
     **/
    public void exit() {
        ChromeDriverGenerator.quitDriver(driver);
    }

    /**
     * @Description: 通过TakesScreenshot截图
     * @Author: zouxianshi
     * @Date: 2021/12/21 17:36
     * @Param []
     * @Return void
     **/
    public void screenShot() {
        driver.switchTo().alert().getText();
        //执行屏幕截图操作
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //通过FileUtils中的copyFile()方法保存getScreenshotAs()返回的文件;"屏幕截图"即时保存截图的文件夹
        try {
            FileUtils.copyFile(srcFile, new File(".\\screenshot\\通过TakesScreenshot截图.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String alert() {
        log.info(driver.switchTo().alert().getText());
        return driver.switchTo().alert().getText();
    }


}