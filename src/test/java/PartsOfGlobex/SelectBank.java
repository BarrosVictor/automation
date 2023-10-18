package PartsOfGlobex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.SleepClass;
import suporte.ValidationResult;

import java.time.Duration;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class SelectBank extends BaseBrowser {

    public SelectBank(WebDriver driver) {
        super(driver);
    }

    public SelectBank clickLogInToMyBankButtom (){
        //Click on the id="bankLogin" button  //*[@id="bankLogin"]
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().frame("paywithmybank-iframe-widget-container");
        new SleepClass().SleepTime(1000);
        driver.findElement(By.id("bankLogin")).click();
        return this;
    }

    public SelectBank searchNameBank(String nameBank){
        //CLICK on searfield"//*[@id="lbx-listBank-inputSearch"]" field
        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.switchTo().frame("paywithmybank-iframe");
        driver.findElement(By.id("lbx-listBank-inputSearch")).sendKeys(nameBank);
        return this;
    }
    public SelectBank searchBankAmerica(String nameBank,String environment){

        //CLICK on searfield"//*[@id="lbx-listBank-inputSearch"]" field
        driver.switchTo().defaultContent();
        if(environment.equals("Dell")){
            driver.switchTo().frame("paywithmybank-iframe-pb-widget");
        } else if (environment.equals("Trial site")) {
            driver.switchTo().frame("paywithmybank-iframe-widget-container");
        } else if (environment.equals("User Portal")){
            new SleepClass().SleepTime(8000);
            driver.switchTo().frame("paywithmybank-iframe");
        }

        if (environment.equals("User Portal")){
            driver.findElement(By.xpath("//*[@id=\"lbx-listBank-inputSearch\"]")).sendKeys(nameBank);
        }
        else {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.id("widgetSearchField")));
            driver.findElement(By.id("widgetSearchField")).sendKeys(nameBank);
        }
        //*[@id="widgetSearchList"]/li[1]
        return this;
    }
    public SelectBank clickOnTheBakSearshedAmerica(String bank, String environment){
        if(environment.equals("User Portal")){
            if (bank.equals("Navy Federal") || bank.equals("PNC")) {
                new SleepClass().SleepTime(3000);
                new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"lbx-listBank-select256074974\"]/div/div")));
                driver.findElement(By.xpath("//*[@id=\"bank-list-inner-container\"]/div")).click();
            } else {
                new SleepClass().SleepTime(3000);
                new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bank-list-inner-container\"]/div[1]")));
                driver.findElement(By.xpath("//*[@id=\"bank-list-inner-container\"]/div[1]")).click();
            }
        }
        else {
            if (bank.equals("Navy Federal") || bank.equals("PNC")) {
                new SleepClass().SleepTime(3000);
                new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"widgetSearchList\"]/li")));
                driver.findElement(By.xpath("//*[@id=\"widgetSearchList\"]/li")).click();

            } else {
                new SleepClass().SleepTime(3000);
                new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"widgetSearchList\"]/li[1]")));
                driver.findElement(By.xpath("//*[@id=\"widgetSearchList\"]/li[1]")).click();
            }
        }
        return this;
    }
    public SelectBank clickOnTheBakSearshed(){
        //Click on "//*[@id="lbx-listBank-select000001429"]/div/div/label/div[2]/div/span[2]" button
        new SleepClass().SleepTime(3000);
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(By.id("lbx-listBank-select000001429")));
        driver.findElement(By.id("lbx-listBank-select000001429")).click();
        return this;
    }

    public ConfirmationOATHBank clickOnGoToDemoBank(){
        //Click on Go to Demo Bank "//*[@id="ExternalRedirect"]/div[1]"
        new SleepClass().SleepTime(3000);
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(By.id("ExternalRedirect")));
        driver.findElement(By.id("ExternalRedirect")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return new ConfirmationOATHBank(driver);
    }

    public ConfirmationOATHBank clickOnGoToBank(String whichBank){

        new WebDriverWait(driver, Duration.ofSeconds(25));
        driver.switchTo().defaultContent();
        driver.switchTo().frame("paywithmybank-iframe");

        if (whichBank.equals("Bank of America")||whichBank.equals("Chase")||whichBank.equals("US Bank")){
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.id("ExternalRedirect")));
            driver.findElement(By.id("ExternalRedirect")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        else {
            new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(By.id("slider-button")));
            //new SleepClass().SleepTime(15000);
            driver.findElement(By.id("slider-button")).click();
        }

        return new ConfirmationOATHBank(driver);
    }

    public SelectBank confirmeAccountBank(){
        //Click on the Continue button "//*[@id="lbx-accountList-submit"]"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().frame("paywithmybank-iframe");
        driver.findElement(By.id("lbx-accountList-submit")).click();
        return this;
    }

    public SelectBank confirmCoOwner(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"lbx-page\"]/div[1]/div/div[4]/button")));
        driver.findElement(By.xpath("//*[@id=\"lbx-page\"]/div[1]/div/div[4]/button")).click();

        return this;
    }

    public SelectBank continueMandateData(){
        //Click on the Continue button "//*[@id="btn-continueButton"]"
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.id("btn-continueButton")));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("btn-continueButton")).click();
        return this;
    }

    public ValidationResult confirmMandate(){
        //Click on the checkbox "//*[@id="lbx-authorizationTextCheckbox-authorizeDirectDebitCheckbox"]"
        new SleepClass().SleepTime(1000);
        driver.findElement(By.className("field-Checkbox-label-text")).click();

        //Click on the Confirm Mandate button "//*[@id="btn-authorizationTextSubmit"]"
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("btn-authorizationTextSubmit")).click();
        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new ValidationResult (driver);
    }
}
