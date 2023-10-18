package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Web {

    public String environment;
    public static WebDriver createChrome(String environment) {

        //Open Browser
        System.setProperty("webdriver.chrome.driver", "/Users/victor.barros/Documents/webdriverJava/tddAutomation/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080","--start-maximized","--remote-allow-origins=*");// ,"--headless" ,"--allowed-ips", "--incognito"
        WebDriver driver = new ChromeDriver(options);


        //load Globex
        driver.get(environment);

        return driver;
    }


}
