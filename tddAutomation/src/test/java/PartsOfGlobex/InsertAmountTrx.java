package PartsOfGlobex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InsertAmountTrx extends BaseBrowser{

    public InsertAmountTrx(WebDriver driver) {
        super(driver);
    }

    public InsertAmountTrx clickCustomAmount (){
        //Click on button Custom to insert amount class="filters-options--amount-option-custom amountOptionJs active"
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"amountOption\"]/div[1]")));
        driver.findElement(By.xpath("//*[@id=\"amountOption\"]/div[1]"));
        return this;
    }
    public SelectEndUser inputAmountTrx(String amount){
        //Insert amount "0.00" in the id="amountInput" field
        driver.findElement(By.id("amountInput")).clear();
        driver.findElement(By.id("amountInput")).sendKeys(amount);
    return new SelectEndUser (driver);
    }
}
