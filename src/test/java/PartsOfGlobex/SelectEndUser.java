package PartsOfGlobex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SelectEndUser extends BaseBrowser {

    public SelectEndUser(WebDriver driver) {
        super(driver);
    }

    public SelectCurrency choiceEndUser(String user){
        //select option "GB - Freddie Mercury" customer in the name="customer" field
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Select customer = new Select(driver.findElement(By.name("customer")));
        customer.selectByVisibleText(user);
        return new SelectCurrency(driver);
    }

}
