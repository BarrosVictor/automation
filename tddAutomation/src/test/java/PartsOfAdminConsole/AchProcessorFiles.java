package PartsOfAdminConsole;

import PartsOfGlobex.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import suporte.SleepClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class AchProcessorFiles extends BaseBrowser {


    public AchProcessorFiles(WebDriver driver) {
        super(driver);
    }
    public AchProcessorFiles ACHTable (String destinationName) {
       WebElement tabela = driver.findElement(By.xpath("//*[@id=\"sortabletable\"]/tbody"));
       List<WebElement> tr = tabela.findElements(By.cssSelector("tr"));
        for (WebElement e : tr) {
            List<WebElement> td = e.findElements(By.cssSelector("td"));
            String colum2 = td.get(1).getText();
            String colum6 = td.get(5).getText();

            if (colum2.equals(destinationName)&&colum6.equals("Opened")){
                e.findElement(By.xpath("td[11]/a")).click();
            }
        }
        new SleepClass().SleepTime(1000);
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());

        String day = timeStamp.substring(0,2);
        String month = timeStamp.substring(3,5);
        String year = timeStamp.substring(6,11);


        WebElement calendar = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/form[2]/div/div/div/div[2]/table/tbody/tr/td[2]/input"));
        calendar.click();
        calendar.click();
        calendar.sendKeys(day,month,year);
        calendar.click();
        calendar.sendKeys(Keys.TAB);

        timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
        String hour = timeStamp.substring(11,13);
        int minute = Integer.parseInt(timeStamp.substring(14,16));
        minute++;

        calendar.sendKeys(hour,String.valueOf(minute));
        driver.findElement(By.xpath("//*[@id=\"modalUpdateFile\"]/div/div/div[3]/button[1]")).click();
        new SleepClass().SleepTime(60000);
        return this;
    }
}
