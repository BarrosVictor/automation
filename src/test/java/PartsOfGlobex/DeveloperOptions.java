package PartsOfGlobex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

public class DeveloperOptions extends BaseBrowser {

    public DeveloperOptions(WebDriver driver) {
        super(driver);
    }

    public DeveloperOptions checkBoxDeveloperOptions(){
        //click on check box //*[@id="filters"]/div[10]/span/label/span
        driver.findElement(By.xpath("//*[@id=\"filters\"]/div[10]/span/label/span")).click();
        return this;
    }

    public DeveloperOptions checkDeveloperOption (){
        //improvment for this method is select variable by field's name and the method receive this information
        //click on the customData option //*[@id="filters"]/div[10]/div[1]/label[5]
        driver.findElement(By.xpath("//*[@id=\"filters\"]/div[10]/div[1]/label[5]")).click();
        return this;
    }

    public DeveloperOptions typeCustomData(){
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());

        String day = timeStamp.substring(0,2);
        String month = timeStamp.substring(3,5);
        String hour = timeStamp.substring(11,13);
        String minute = timeStamp.substring(14,16);
        //Insert value "{"metadata":{"flowType" :"tdd"},"merchantReference": "TUI12SEP005"}" in the field id="establishExtraData"
        driver.findElement(By.id("establishExtraData")).sendKeys("{\"metadata\":{\"flowType\" :\"tdd\"},\"merchantReference\": \"AUT"+day+month+hour+minute+"\"}");
        return this;
    }
    public SelectBank clickSaveButtomCustomData(){
        //Click on the Save button by id="saveEstablishExtraData"
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.id("saveEstablishExtraData")));
        driver.findElement(By.id("saveEstablishExtraData")).click();
        return new SelectBank(driver);
    }

}
