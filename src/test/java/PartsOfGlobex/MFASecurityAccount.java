package PartsOfGlobex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.ScreenShot;
import suporte.SleepClass;
import javax.swing.*;
import java.time.Duration;

public class MFASecurityAccount extends BaseBrowser {
    public MFASecurityAccount(WebDriver browser) {
        super(browser);
    }
    public MFASecurityAccount ClickTypeVerifyMFA(String bank, String environment){
        //Time to wait the screen to construct the frame
        new SleepClass().SleepTime(5000);

        //Constructing again the frame to work with MFA
        driver.switchTo().defaultContent();
        driver.switchTo().frame("paywithmybank-iframe");
        driver.switchTo().frame("lbx-iframeAuthenticate");

        //Condition to work with different bank and user
        if (bank.equals("Capital One")){
            new SleepClass().SleepTime(6000);
            driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/div[2]/div[5]/label")).click();
        }else if (bank.equals("PNC")) {
            new SleepClass().SleepTime(3000);
            if(ConfirmationOATHBank.getUsernameBank().equals("PNCbankDLI")){
                driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/div/div[1]/label")).click();
            } else if (ConfirmationOATHBank.getUsernameBank().equals("JPARSONS21")||ConfirmationOATHBank.getUsernameBank().equals("trustly.kush")) {
                driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/div/div[5]/label/span[2]")).click();
            } else {
                driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/div[2]/div[1]/label")).click();
            }
        } else if (bank.equals("Navy Federal")) {
            new SleepClass().SleepTime(6000);
            driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/div[2]/div[3]/label")).click();
        }

        return this;
    }

    public MFASecurityAccount ConfirmMFASecutiyCode(String bank, String environment){
        //Constructing again the frame to work with MFA
        new SleepClass().SleepTime(8000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("paywithmybank-iframe");
        driver.switchTo().frame("lbx-iframeAuthenticate");

        //Dialogbox to innsert the MFA Security Code
        String securityCodeBank= JOptionPane.showInputDialog("Insert Security Code "+bank + environment);
        driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/div/input")).sendKeys(securityCodeBank);
        driver.findElement(By.id("lbx-formLogin-submit")).click();
        JOptionPane.showInternalConfirmDialog(null,"The bank return to portal with successfully?");
        driver.switchTo().defaultContent();
        return this;
    }

}
