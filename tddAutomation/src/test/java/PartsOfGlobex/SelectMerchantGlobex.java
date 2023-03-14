package PartsOfGlobex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectMerchantGlobex extends BaseBrowser {
    public SelectMerchantGlobex(WebDriver driver) {

        super(driver);
    }

    public SelectTypeTrx typeIdMerchant(String idMerchant){
        //Select MERCHANT id="merchantList"
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.id("merchantList")));

        Select merchantList = new Select(driver.findElement(By.id("merchantList")));
        merchantList.selectByVisibleText("Custom");

        //Insert value "1001152876" in the merchant Id id="customMerchantId" field
        driver.findElement(By.id("customMerchantId")).sendKeys(idMerchant);

        //Click on Add button to add merchant id="addCustomMerchant"
        driver.findElement(By.id("addCustomMerchant")).click();
        return new SelectTypeTrx(driver);
    }
}
