package cn.hydee.webui.control.basecomponent;

public class Constant {
	public final static String SCREEN_SHOT_PATH = "snapshot";

	// linux下chromedriver安装路径
	public final static String DRIVER_PATH_LINUX = "/usr/local/share/chromedriver";

	// windows下chromedriver安装路径
	public final static String DRIVER_PATH_WIN = "src\\main\\resources\\chromedriver.exe";

	// windows系统标识
	public final static String OS_WIN = "Windows";

	// linux系统标识
	public final static String OS_LINUX = "Linux";

	// chromedriver类型
	public final static String DRIVER_TYPE_CHROME = "webdriver.chrome.driver";

	// chromedriver静默模式
	public final static String CHROME_SILENCE_MODE = "--headless";
	
	// chromedriver默认最大化窗口
	public final static String CHROME_MAX_WINDOW = "--start-maximized";
	
	//元素等待时间
	public final static int ELEMENT_WAIT_TIME = 20;
	
	//显示分辨率横坐标
	public final static int DIMENSION_FULLSCREEN_X = 1366;
	
	//显示分辨率纵坐标
	public final static int DIMENSION_FULLSCREEN_Y = 768;
}
