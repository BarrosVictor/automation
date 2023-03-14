package PartsDellProdTest;

import PartsOfGlobex.BaseBrowser;
import PartsOfGlobex.SelectBank;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TypePayment extends BaseBrowser {
    public TypePayment(WebDriver driver) {
        super(driver);
    }
    public SelectBank ClickOnlineBank(){
        //clicar na opção onlinebank
        //browser.switchTo().frame("paywithmybank-iframe");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cartPaymentsPage\"]/section/div[6]/div[2]/tabbed-payment-types/div[1]/div[6]")));
        driver.findElement(By.linkText("Online Banking")).click();
        //browser.findElement(By.xpath("//*[@id=\"cartPaymentsPage\"]/section/div[6]/div[2]/tabbed-payment-types/div[1]/div[6]")).click();

        return new SelectBank(driver);
    }
}
