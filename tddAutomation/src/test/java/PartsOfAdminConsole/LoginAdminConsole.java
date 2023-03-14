package PartsOfAdminConsole;

import PartsOfGlobex.BaseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAdminConsole extends BaseBrowser {
    public LoginAdminConsole(WebDriver driver) {
        super(driver);
    }



    //Insert login id="username" return to login
    public LoginAdminConsole InsertLogin(String login){
        driver.findElement(By.id("username")).sendKeys(login);
        return this;
    }
    //Insert password id="password" return to login
    public LoginAdminConsole InsertPassword(String password){
        driver.findElement(By.id("password")).sendKeys(password);
        return this;
    }
    //Click login buttom id="btn-login" return to home page
    public HomeAdminConsole ClickLogin(){
        driver.findElement(By.id("btn-login")).click();
        return new HomeAdminConsole(driver);
    }
}
