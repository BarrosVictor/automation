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
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"segmentSelector\"]//div/fieldset/div[2]/div[1]/div/label")));
        driver.findElement(By.xpath("//*[@id=\"segmentSelector\"]//div/fieldset/div[2]/div[1]/div/label")).click();
        return this;
    }
    public PersonalAdress clickOnSelectAdress(){
        //Selecionar o botão select do endereço
        //new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.linkText("Select")));
        driver.findElement(By.xpath("//*[@id=\"addressViewList\"]/div[4]/div[1]/table/tbody/tr/td[3]/div/div/div[1]/button")).click();
        return this;
    }

    public TypePayment ClickNextPayment(){
        // clicar no botão next payment
        driver.findElement(By.xpath("//*[@id=\"cart-summary-right\"]/div/div/div[1]/div[5]")).click();
        return new TypePayment(driver);
    }
}
