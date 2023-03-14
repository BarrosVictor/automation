package PartsOfGlobex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.ScreenShot;
import suporte.SleepClass;
import suporte.ValidationResult;

import javax.swing.*;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class ConfirmationOATHBank extends BaseBrowser {
    private static String usernameBank;
    private static String password;
    private String parent;
    public ConfirmationOATHBank(WebDriver driver) {
        super(driver);
    }

        public SelectBank OAuthBank(){
        //Click on "TAB" in the keyboard
        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {

            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                driver.findElement(By.id("username")).sendKeys("Automation");
                driver.findElement(By.id("password")).sendKeys("Automation");
                driver.findElement(By.xpath("/html/body/form/input[4]")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                driver.findElement(By.xpath("/html/body/form/button[1]")).click();
                driver.switchTo().window(parent);
            }

        }
    return new SelectBank(driver);
    }

    public MFASecurityAccount OAuthProdBank (String bank, String environment){
        driver.switchTo().frame("lbx-iframeAuthenticate");
            //dialogbox to insert account username
            this.insertUsernameBank(bank, environment);
            this.insertPasswordBank(bank,environment);
            //submit button after inserted data account bank can be id=lbx-formLogin-submit
            new SleepClass().SleepTime(4000);
        driver.findElement(By.xpath("/html/body/div/div/div/form/div[4]/button")).click();
            new SleepClass().SleepTime(3000);
            //*Incluir validação de banco conectando*//

        return new MFASecurityAccount(driver);
    }

    public ConfirmationOATHBank OAuthPSD2ProdBank(String bank, String environment){
                //switch to bank PSD2 screen
                this.switchToScreenBankPSD2();
                this.insertUsernameBank(bank, environment);
                this.insertPasswordBank(bank,environment);
                if (bank.equals("Bank of America")) {
                    //select text option to send msg
                    driver.findElement(By.id("TEXT4")).click();
                    driver.findElement(By.id("send-otp-code")).click();

                    //getting code MFA
                    String autCodeBOFA = JOptionPane.showInputDialog("Insert Authorization Code BOFA " + environment);
                    driver.findElement(By.id("twAuthcodeModule-otp-code")).sendKeys(autCodeBOFA);
                    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/section[3]/div/div/div/div/div/div[5]/div/section/section[2]/section[5]/div/button")).click();

                    //wait consent-submit
                    new SleepClass().SleepTime(2000);
                    driver.findElement(By.id("consent-submit")).click();
                    JOptionPane.showInternalConfirmDialog(null, "The bank return to portal with successfully?");
                }else{
                    JOptionPane.showInternalConfirmDialog(null, "The bank return to portal with successfully?");
                }
        driver.switchTo().window(parent);
        return this;
    }

    private ConfirmationOATHBank insertPasswordBank(String bank, String environment) {
        this.setPasswordBank(JOptionPane.showInputDialog("Insert Password"+ bank + environment));
        if (bank.equals("Chase")) {
            driver.findElement(By.xpath("//*[@id=\"password-text-input-field\"]")).sendKeys(this.getPasswordBank());
            driver.findElement(By.xpath("//*[@id=\"signin-button\"]")).click();
        }
        else if (bank.equals("Bank of America")) {
            driver.findElement(By.name("pass")).sendKeys(this.getPasswordBank());
            //submit button can be id=secure-signin-submit
            driver.findElement(By.id("secure-signin-submit")).click();
        }
        //Acation that insert any account password
        else if(bank.equals("Navy Federal")){
            driver.findElement(By.id("lbx-formAuthenticate-authFields-inputPASSWORD")).sendKeys(this.getPasswordBank());
        }
        else {
            driver.findElement(By.id("lbx-formAuthenticate-authFields-inputpassword")).sendKeys(this.getPasswordBank());
        }
        return this;
    }

    public ConfirmationOATHBank insertUsernameBank(String bank, String environment){
        this.setUsernameBank(JOptionPane.showInputDialog("Insert Account Username "+ bank + environment));

        if (bank.equals("Chase")) {
            new SleepClass().SleepTime(5000);
            driver.switchTo().frame("logonbox");
            //driver.findElement(By.xpath("//*[@id=\"userId-label\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"userId-text-input-field\"]")).sendKeys(this.getUsernameBank());
        }else if (bank.equals("Bank of America")) {
            driver.findElement(By.name("oid")).sendKeys(this.getUsernameBank());
        }  else if (bank.equals("PNC")){
            //Action that insert the PNC account username
            driver.findElement(By.id("lbx-formAuthenticate-authFields-inputuserId")).sendKeys(this.getUsernameBank());
        } else if (bank.equals("Navy Federal")) {
            driver.findElement(By.id("lbx-formAuthenticate-authFields-inputUSER")).sendKeys(this.getUsernameBank());
        } else {
            //Action that insert the Capital One account username
            driver.findElement(By.id("lbx-formAuthenticate-authFields-inputusername")).sendKeys(this.getUsernameBank());
        }
        return this;
    }
    public ConfirmationOATHBank switchToScreenBankPSD2(){
        parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> I1 = s.iterator();
        while (I1.hasNext()) {

            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
        return this;
    }
    public static String getUsernameBank(){
        return ConfirmationOATHBank.usernameBank;
    }
    public void setUsernameBank(String usernameBank){
        this.usernameBank = usernameBank;
    }
    public static String getPasswordBank(){
        return ConfirmationOATHBank.password;
    }
    public void setPasswordBank(String passwordBank){
        this.password = passwordBank;
    }
}
