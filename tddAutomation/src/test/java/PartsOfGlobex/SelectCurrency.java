package PartsOfGlobex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SelectCurrency extends BaseBrowser {

    public SelectCurrency(WebDriver driver) {
        super(driver);
    }

    public DeveloperOptions choiceCurrency (String currency){
        //select option "GBP - United Kingdom" currency in the name="currency" field
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        Select varCurrency = new Select(driver.findElement(By.name("currency")));
        varCurrency.selectByVisibleText(currency);
        return new DeveloperOptions(driver);
    }
}

