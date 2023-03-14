package PartsOfAdminConsole;

import PartsOfGlobex.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.ScreenShot;
import suporte.SleepClass;

import java.time.Duration;

public class TransactionStatusScreen extends BaseBrowser {

    public TransactionStatusScreen(WebDriver driver) {
        super(driver);
    }
    //Click Operations linkText return to trxStatus
    public TransactionStatusScreen ClickOperations(){
        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul"))));
        driver.findElement(By.linkText("Operations")).click();
        return this;
    }
    //Insert msgCancel in cancel message field return to trxStatus
    public TransactionStatusScreen InsertCancelationMessage(String messageCancel){
        driver.findElement(By.xpath("//*[@id=\"cancelTransaction\"]/form/div/div/div/input")).sendKeys(messageCancel);
        return this;
    }
    //Click on Cancel Buttom return to trxStatus
    public TransactionStatusScreen SubmitTrxCancel(){
        driver.findElement(By.xpath("//*[@id=\"cancelTransaction\"]/form/div/div/input")).click();
        return this;
        //Cancelled with success.
    }
    //Click on Ok confirm buttom class="btn btn-success js-btok"
    public TransactionStatusScreen ConfimationSubmitTrxCancelButtom(){
        new SleepClass().SleepTime(2000);
        driver.findElement(By.xpath("//*[@id=\"modal-message\"]/div/div/div[3]/button[1]")).click();
        return this;
    }
    //Verify is trx was completed
    public TransactionStatusScreen VerifyOperatiosSuccess(String expectedResult){
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"infoMessage\"]")));
        String  obtainedResult = driver.findElement(By.xpath("//*[@id=\"infoMessage\"]")).getText();
        String trxID = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/table/tbody/tr/td[1]")).getText();
        if (!expectedResult.equals("Cancelled with success.")){
            obtainedResult=obtainedResult.substring(0,39);
        }
        try {
            if (obtainedResult.equals(expectedResult)){
                ScreenShot.take(driver, "/Users/victor.barros/Documents/webdriverJava/tddAutomation/evidence/" + Generator.dateHourToFile() + "-" + trxID + "-" + obtainedResult);

            }
        }
        catch(Exception e) {
            ScreenShot.take(driver,"/Users/victor.barros/Documents/webdriverJava/tddAutomation/evidence/"+ Generator.dateHourToFile()+"-"+trxID+"-"+obtainedResult+e);
            //  Block of code to handle errors
        }
        return this;
    }
    //Insert captureAmount on capture amount field
    public TransactionStatusScreen InsertCaptureAmount(String captureAmount){
        driver.findElement(By.xpath("//*[@id=\"captureTrx\"]/form/table/tbody/tr[1]/td[2]/input")).sendKeys(captureAmount);
        return this;
    }
    //Click on Capture buttom
    public TransactionStatusScreen SubmitCapture(){
        driver.findElement(By.xpath("//*[@id=\"captureTrx\"]/form/input[2]")).click();
        return this;
        //Capture created with status Authorized.
    }

    //Insert depositAmount on deposit amount field
    public TransactionStatusScreen InsertDepositAmount(String depositAmount){
        driver.findElement(By.xpath("//*[@id=\"deposit\"]/form/table/tbody/tr[1]/td[2]/input")).sendKeys(depositAmount);
        return this;
    }
    //Click on Deposit buttom
    public TransactionStatusScreen SubmitDeposit(){

        driver.findElement(By.xpath("//*[@id=\"deposit\"]/form/input[1]")).click();
        return this;
        //Capture created with status Authorized.
        //Deposit created with status Authorized.
    }

}
