package tests;

import PartsDellProdTest.DellProdCartTest;
import PartsDellProdTest.LoginDellProdTest;
import PartsDellProdTest.PersonalAdress;
import PartsDellProdTest.TypePayment;
import PartsOfGlobex.*;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.jfree.ui.about.resources.AboutResources;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.SleepClass;
import suporte.Web;

import javax.swing.*;
import java.time.Duration;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "tddFileTrxDell.csv")

public class ProductionEnvironmentTest {
    private WebDriver driver;
    private static String  env;
    @Rule
    public TestName test = new TestName();

    @Test
    public void testCreateTransactionPRDDell(@Param(name="environment")String environment,
                                         @Param(name="bank")String bank){

        driver = Web.createChrome(environment);
        env = "Dell";
        new DellProdCartTest(driver)
                .AddCart();
        new LoginDellProdTest(driver)
                .InsertLogin()
                .InsertPassword()
                .WorkingCatpcha()
                .ClickonSignInButtom();
        new PersonalAdress(driver)
                .ClickOnPersonalRadoButtom()
                .ClickNextPayment();
        new TypePayment(driver)
                .ClickOnlineBank();

        new SelectBank(driver)
                .searchBankAmerica(bank,env)
                .clickOnTheBakSearshedAmerica(bank,env)
                .clickOnGoToBank(bank);
        ConfirmationOATHBank t = new ConfirmationOATHBank(driver);
            if (bank.equals("Bank of America") || bank.equals("Chase")){
                t.OAuthPSD2ProdBank(bank,env);
            }
            else {
                t.OAuthProdBank(bank,env);
            }
            new MFASecurityAccount(driver)
                    .ClickTypeVerifyMFA(bank,env)
                    .ConfirmMFASecutiyCode(bank,env);

    }
    @Test
    public void testCreateTransactionPRDDTrialSite(@Param(name="environment")String environment,
                                             @Param(name="bank")String bank){

        driver = Web.createChrome(environment);
        env = "Trial site";
        new SelectBank(driver)
                .searchBankAmerica(bank,env)
                .clickOnTheBakSearshedAmerica(bank,env)
                .clickOnGoToBank(bank);
        ConfirmationOATHBank t = new ConfirmationOATHBank(driver);
        if (bank.equals("Bank of America") || bank.equals("Chase")){
            t.OAuthPSD2ProdBank(bank,env);
        }
        else {
            t.OAuthProdBank(bank,env);
            new MFASecurityAccount(driver)
                    .ClickTypeVerifyMFA(bank,env)
                    .ConfirmMFASecutiyCode(bank,env);
        }
    }
    @Test
    public void testCreateTransactionPRDDUserPortal(@Param(name="environment")String environment,
                                                   @Param(name="bank")String bank){

        driver = Web.createChrome(environment);
        env = "User Portal";
        driver.switchTo().frame(0);
        //Click on confirm checkbox captcha
        driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
        //Click on Continue button reCaptcha
        JOptionPane.showConfirmDialog(null,"Is it possible to continue?");
        new SleepClass().SleepTime(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("establish")).click();



        new SelectBank(driver)
                .searchBankAmerica(bank,env)
                .clickOnTheBakSearshedAmerica(bank,env)
                .clickOnGoToBank(bank);
        ConfirmationOATHBank t = new ConfirmationOATHBank(driver);
        if (bank.equals("Bank of America") || bank.equals("Chase")){
            t.OAuthPSD2ProdBank(bank,env);
        }
        else {
            t.OAuthProdBank(bank,env);
            new MFASecurityAccount(driver)
                    .ClickTypeVerifyMFA(bank,env)
                    .ConfirmMFASecutiyCode(bank,env);
        }

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

