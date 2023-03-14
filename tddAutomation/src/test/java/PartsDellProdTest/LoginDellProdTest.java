package PartsDellProdTest;

import PartsOfGlobex.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class LoginDellProdTest extends BaseBrowser {

    public LoginDellProdTest(WebDriver driver) {
        super(driver);
    }

    public LoginDellProdTest InsertLogin(){
        //login de acesso
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("SignInModel_EmailAddress")));
        driver.findElement(By.id("SignInModel_EmailAddress")).sendKeys("victor.barros@trustly.com");
        return this;
    }
    public LoginDellProdTest InsertPassword(){
        //Senha de acesso
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("userPwd_UserInputSecret")));
        driver.findElement(By.id("userPwd_UserInputSecret")).sendKeys("dgX0TX>N8N");
        return this;
    }

    public LoginDellProdTest WorkingCatpcha (){
        // Dialogbox to insert the captcha displayed
        String keyCaptcha= JOptionPane.showInputDialog("insert key captcha");
        ///inserir o captcha
        driver.findElement(By.name("ImageText")).sendKeys(keyCaptcha);
        return this;
    }
    public PersonalAdress ClickonSignInButtom (){
        // clicar botao radio id="ZeroSegmentOrderForHomeTrue"
        driver.findElement(By.id("btnSignIn")).click();
        return new PersonalAdress(driver);
    }

}
