package PartsOfAdminConsole;

import PartsOfGlobex.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.ScreenShot;
import suporte.ValidationResult;

import java.time.Duration;
import java.util.List;

public class FiGatewayPro extends BaseBrowser {

    public FiGatewayPro(WebDriver driver) {
        super(driver);
    }

    public FiGatewayPro Jobexecute(String jobExecute) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"frm1\"]/table/tbody")));
        WebElement tabela = driver.findElement(By.xpath("//*[@id=\"frm1\"]/table/tbody"));
        List<WebElement> tr = tabela.findElements(By.cssSelector("tr"));
        for (WebElement e : tr) {
            List<WebElement> td = e.findElements(By.cssSelector("td"));
            String colum2 = td.get(0).getText();
            if (colum2.equals(jobExecute)){
                e.findElement(By.xpath("td[6]/button")).click();
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"infoMessage\"]")));
                String result = driver.findElement(By.xpath("//*[@id=\"infoMessage\"]")).getText();
                if(result.equals("Execution Requested successful. Please wait for a while and then check the log for the full service execution result.")){
                    ScreenShot.take(driver,"/Users/victor.barros/Documents/webdriverJava/tddAutomation/evidence/"+ Generator.dateHourToFile()+" Success.");
                    return this;
                }
            }
        }

        return null;
    }
}
