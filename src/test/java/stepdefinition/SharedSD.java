package stepdefinition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.ConfigReader;

public class SharedSD {

	private static WebDriver driver = null;
	public static final String USERNAME = "Aelya";
	public static final String ACCESS_KEY = "ebf5ee42-64c8-4c12-a28c-227595ec63cc";
	public static final String SAUCE_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	@Before("@web")
	public static void before() throws MalformedURLException {

        ConfigReader configReader = new ConfigReader();

        System.setProperty("webdriver.chrome.driver", configReader.getChromeDriverPath());
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(configReader.getUrl());
    }


//        if (configReader.getSauceOrLocal().equalsIgnoreCase("sauce")) {
//            DesiredCapabilities caps = null;
////            configReader.getPlatform();
////            configReader.getVersion();
//            caps.setCapability("platform", "Windows 10");
//            caps.setCapability("version", "latest");
//            driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
//
//            switch (configReader.getBrowser()) {
//                case "chrome":
//                    caps = DesiredCapabilities.chrome();
//                    break;
//                case "safari":
//                    caps = DesiredCapabilities.safari();
//                    break;
//                case "firefox":
//                    caps = DesiredCapabilities.firefox();
//                    break;
//                case "explorer":
//                    caps = DesiredCapabilities.internetExplorer();
//                    break;
//            }
//
//        } else {
//            if (configReader.getSauceOrLocal().equalsIgnoreCase("local")) {
//                driver = new ChromeDriver();
//                System.setProperty("webdriver.chrome.driver", configReader.getChromeDriverPath());
//                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                driver.get(configReader.getUrl());
//            }
//        }
//    }

	@After("@web")
	public static void after() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}
	public static WebDriver getDriver() { return driver; }
}
