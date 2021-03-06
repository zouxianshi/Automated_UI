package cn.hydee.webui.control.basecomponent;

import cn.hydee.webui.control.driver.ChromeDriverGenerator;
import junit.framework.Assert;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author : zouxianshi
 * @date : 2020年7月18日
 * @description: 基础控件管理类
 */
@Slf4j
public class BaseComponent {
    static WebDriver driver = ChromeDriverGenerator.getDriver();


    /**
     * @return : Boolean ret: true or false
     * @description : 获取url
     * @author : zouxianshi
     * @date : 2020年7月18日
     * @parameter : String url
     */

    public static void getUrl(String url) {
        WebDriver driver = ChromeDriverGenerator.getDriver();
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
    public static void waitTime(long time) {
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
    public static WebElement findElementBy(ElementType type, String value) throws Exception {
        WebElement element = null;
        // 获取查找元素by对象
        final By by = getBy(type, value);
        try {
            // 查找元素显式等待指定时间，内部类实现查找元素并等待
            WebDriverWait wait = new WebDriverWait(driver, Constant.ELEMENT_WAIT_TIME);
            element = wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(by);
                }
            });

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
    public static List<WebElement> findElementsBy(ElementType type, String value) {
        List<WebElement> elements = null;
        // 获取查找元素by对象
        final By by = getBy(type, value);
        try {
            // 查找元素显式等待指定时间，内部类实现查找元素并等待
            WebDriverWait wait = new WebDriverWait(driver, Constant.ELEMENT_WAIT_TIME);
            elements = wait.until(new ExpectedCondition<List<WebElement>>() {
                public List<WebElement> apply(WebDriver driver) {
                    return driver.findElements(by);
                }
            });
            // wait.until(ExpectedConditions.elementToBeClickable(by));
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
    private static Boolean waitElementDisplayed(final WebElement element) {
        Boolean ret = false;
        if (element == null)
            return ret;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Constant.ELEMENT_WAIT_TIME);
            ret = wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return element.isDisplayed();
                }
            });

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
    private static By getBy(ElementType type, String value) {
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
    public static void sendKeys(WebElement element, String keys) {
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
    public static void sendKeys(WebElement element, Keys keys) {
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
    public static void click(WebElement element) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Constant.ELEMENT_WAIT_TIME);
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
    public static void select(final WebElement element) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Constant.ELEMENT_WAIT_TIME);
            // 等待元素显示
            if (waitElementDisplayed(element)) {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                wait.until(ExpectedConditions.elementToBeSelected(element));
                // wait.until(new ExpectedCondition<Boolean>(){
                // public Boolean apply(WebDriver driver) {
                // element.click();
                // return true;
                // }
                // });
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
    public static void checkElementValue(WebElement element, String text) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Constant.ELEMENT_WAIT_TIME);
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
    public static void checkElementNotDiplay(final WebElement element) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Constant.ELEMENT_WAIT_TIME);
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
    public static void switchToFrame(WebElement element) {
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
    public static void clearElement(WebElement element) throws Exception {
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
    public static void switchToDefault() throws Exception {
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
    public static void navigateToUrl(String url) throws Exception {
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
    public static void actionMoveToElement(WebElement element) throws Exception {
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
    public static void actionDoubleClick(WebElement element) throws Exception {
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
    public static void moveToElementByJs(WebElement element) throws Exception {
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
    public static void setDriver(WebDriver webdriver) {
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
    public static void waitForLoadingEleDisappear(ElementType type, String value, long maxWaitTimeout) {
        // 获取查找元素by对象
        waitTime(1);
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
     * @author zouxianshi
     * @date 2020/7/18
     */
    public static Boolean checkElementIsExisted(ElementType type, String value) throws Exception {
        // 获取查找元素by对象
        waitTime(2);
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
    public static void selectByVisibleText(WebElement element, String visibleText, String tagName) throws Exception {
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
    public static void actionEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    /**
     * @author: zouxianshi
     * @description 退出chrome
     */
    public static void exit() {
        ChromeDriverGenerator.quitDriver(driver);
    }
}
