package PartsOfGlobex;

import org.openqa.selenium.WebDriver;

public class BaseBrowser {
    protected WebDriver driver;
    public BaseBrowser (WebDriver browser){

        this.driver=browser;
    }
}
