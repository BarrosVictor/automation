package suporte;

import PartsOfGlobex.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.apache.commons.lang.StringUtils.substring;

public class ValidationResult extends BaseBrowser {
    public String trxId;
    public ValidationResult(WebDriver driver) {
        super(driver);
    }

    public Boolean CheckReturnAcoountPayment(String env){
        new SleepClass().SleepTime(12000);
        driver.switchTo().frame("paywithmybank-iframe");
        Boolean result;
        if (driver.findElement(By.id("lbx-accountList-select0")).isDisplayed()){
             result = true;
        }else {
            result = false;
        }
        ScreenShot.take(driver,"/Users/victor.barros/Documents/webdriverJava/tddAutomation/evidence/"+Generator.dateHourToFile()+"-"+env);
        driver.switchTo().defaultContent();

        return result;
    }
    public String  CheckResult(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.switchTo().defaultContent();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div.trx-result.trx-success")));
        String  expectedresult = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]")).getText();
        expectedresult = expectedresult.substring(27,37);

        ScreenShot.take(driver,"/Users/victor.barros/Documents/webdriverJava/tddAutomation/evidence/"+Generator.dateHourToFile()+"-"+expectedresult);
        return expectedresult;
    }
}
