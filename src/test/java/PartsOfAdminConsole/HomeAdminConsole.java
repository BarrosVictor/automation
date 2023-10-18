package PartsOfAdminConsole;

import PartsOfGlobex.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.SleepClass;

import java.time.Duration;

public class HomeAdminConsole extends BaseBrowser {

    public HomeAdminConsole(WebDriver driver) {
        super(driver);
    }
    //Click trxId link linkText = trxId retunr to trxStatus
    public TransactionStatusScreen ClickOnTrxId (String trxId){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/nav/ul[2]")));
        driver.findElement(By.linkText(trxId)).click();
        return new TransactionStatusScreen(driver);
    }
    public HomeAdminConsole UpperMenuServices (String subMenuServices) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/nav/ul[1]/li[4]/a")));
        driver.findElement(By.xpath("/html/body/nav/div/nav/ul[1]/li[5]/a")).click();
        switch (subMenuServices) {
            case "ACH Processor":
                // code block
                driver.findElement(By.xpath("/html/body/nav/div/nav/ul[1]/li[5]/ul/li[1]/a")).click();
                break;
            case "FI Gateway Processor":
                driver.findElement(By.xpath("//html/body/nav/div/nav/ul[1]/li[5]/ul/li[2]/a")).click();
                break;
            case "Merchant Processor":
                driver.findElement(By.xpath("//html/body/nav/div/nav/ul[1]/li[5]/ul/li[3]/a")).click();
                break;
            case "FIC Processor":
                driver.findElement(By.xpath("//html/body/nav/div/nav/ul[1]/li[5]/ul/li[4]/a")).click();
                break;
            default:
                driver.findElement(By.xpath("//html/body/nav/div/nav/ul[1]/li[5]/ul/li[5]/a")).click();
        }
        return this;
    }
    public HomeAdminConsole UpperMenuManager (String subMenuManager){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/nav/ul[1]/li[4]/a")));
        driver.findElement(By.xpath("/html/body/nav/div/nav/ul[1]/li[3]/a")).click();
        switch (subMenuManager) {
            case "Destinations":
                WebElement mainMenu = driver.findElement(By.xpath("/html/body/nav/div/nav/ul[1]/li[3]/ul/li[1]/a"));
                Actions builder= new Actions(driver);
                builder.moveToElement(mainMenu).build().perform();
                driver.findElement(By.xpath("/html/body/nav/div/nav/ul[1]/li[3]/ul/li[1]/ul/li[1]/a")).click();
                break;
            case "FI Gateway Processor":
                driver.findElement(By.xpath("//html/body/nav/div/nav/ul[1]/li[4]/ul/li[2]/a")).click();
                break;
            case "Merchant Processor":
                driver.findElement(By.xpath("//html/body/nav/div/nav/ul[1]/li[4]/ul/li[3]/a")).click();
                break;
            case "FIC Processor":
                driver.findElement(By.xpath("//html/body/nav/div/nav/ul[1]/li[4]/ul/li[4]/a")).click();
                break;
             default:
                 driver.findElement(By.xpath("//html/body/nav/div/nav/ul[1]/li[4]/ul/li[5]/a")).click();
        }
        return this;
    }
}


