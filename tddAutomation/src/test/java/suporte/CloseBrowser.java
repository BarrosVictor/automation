package suporte;

import org.openqa.selenium.WebDriver;

public class CloseBrowser {
    private WebDriver driver;
    public CloseBrowser(WebDriver browser) {
        this.driver=browser;
    }
    public void fecharbrowser(){
        driver.quit();

    }


}
