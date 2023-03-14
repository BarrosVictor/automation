package PartsOfAdminConsole;

import PartsOfGlobex.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.SleepClass;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

public class ACHProConfigDestinations extends BaseBrowser {
    public ACHProConfigDestinations(WebDriver driver) {
        super(driver);
    }
    public ACHProConfigDestinations SelectACHProConfigDestination (String destinationName) {
        WebElement tabela = driver.findElement(By.xpath("//*[@id=\"sortabletable\"]/tbody"));
        List<WebElement> tr = tabela.findElements(By.cssSelector("tr"));
        for (WebElement e : tr) {
            List<WebElement> td = e.findElements(By.cssSelector("td"));
            String colum2 = td.get(1).getText();

            if (colum2.equals(destinationName)) {
                e.findElement(By.xpath("td[7]/a[1]")).click();
                return this;
            }
        }
    return this;
    }
    public ACHProConfigDestinations ACHProChangeExchangeWindowsDestination () {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[1]/div/form/fieldset[1]/fieldset/table/tbody/tr/td[5]/a[1]")));
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/form/fieldset[1]/fieldset/table/tbody/tr/td[5]/a[1]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"odfiCutoff\"]")));
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());

        String hour = timeStamp.substring(11,14);
        int minute = Integer.parseInt(timeStamp.substring(14,16));
        minute++;
        WebElement calendarcutoff = driver.findElement(By.xpath("//*[@id=\"cutoff\"]"));
        calendarcutoff.click();
        calendarcutoff.sendKeys(hour,String.valueOf(minute));
        WebElement calendarodficutoff = driver.findElement(By.xpath("//*[@id=\"odfiCutoff\"]"));
        calendarodficutoff.click();
        calendarodficutoff.sendKeys(hour,String.valueOf(minute));

        driver.findElement(By.xpath("//*[@id=\"local-header-save\"]")).click();
        new SleepClass().SleepTime(60000);
        return this;
    }

}
