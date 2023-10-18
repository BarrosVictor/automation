package PartsDellProdTest;

import PartsOfGlobex.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DellProdCartTest extends BaseBrowser {

    public DellProdCartTest(WebDriver driver) {
        super(driver);
    }
    public LoginDellProdTest AddCart (){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.linkText("Add to Cart")));
        driver.findElement(By.linkText("Add to Cart")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.id("checkout-btn-cta")).click();
        return new LoginDellProdTest(driver);
    }

}
