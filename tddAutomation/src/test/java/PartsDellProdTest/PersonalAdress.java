package PartsDellProdTest;

import PartsOfGlobex.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAdress extends BaseBrowser {
    public PersonalAdress(WebDriver driver) {
        super(driver);
    }

    public PersonalAdress ClickOnPersonalRadoButtom(){
        //Selecionar o radiobuttom Personal
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ZeroSegmentOrderForHomeTrue\"]")));
        driver.findElement(By.xpath("//*[@id=\"ZeroSegmentOrderForHomeTrue\"]")).click();
        return this;
    }

    public TypePayment ClickNextPayment(){
        // clicar no botão next payment
        driver.findElement(By.xpath("//*[@id=\"cart-summary-right\"]/div/div/div[1]/div[5]")).click();
        return new TypePayment(driver);
    }
}
