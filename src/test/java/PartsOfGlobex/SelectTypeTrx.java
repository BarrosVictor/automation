package PartsOfGlobex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import suporte.SleepClass;


public class SelectTypeTrx extends BaseBrowser {

    public SelectTypeTrx(WebDriver driver) {
        super(driver);
    }

    public InsertAmountTrx choiceTypeTrx (String trxType){
        //Select payment  type id="paymentType" with value value="Deferred"
        new SleepClass().SleepTime(1000);
        Select paymentType = new Select(driver.findElement(By.id("paymentType")));
        paymentType.selectByVisibleText(trxType);
        return new InsertAmountTrx (driver);
    }
}
