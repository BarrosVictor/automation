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
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"cart-summary-right\"]/div/div/div[1]/div[4]/div[2]/div[1]/button")).click();
        return new LoginDellProdTest(driver);
    }

}
