package tests;

import PartsDellProdTest.*;
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
import suporte.ValidationResult;
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
                //.clickLogin()
                .InsertLogin()
                .InsertPassword()
                .WorkingCatpcha()
                .ClickonSignInButtom();
        /*new SearchProduct(driver)
                .makingSearch();*/
        new PersonalAdress(driver)
                //.ClickOnPersonalRadoButtom()
                .clickOnSelectAdress()
                .ClickNextPayment();
        new TypePayment(driver)
                .ClickOnlineBank();

        new SelectBank(driver)
                .searchBankAmerica(bank,env)
                .clickOnTheBakSearshedAmerica(bank,env)
                .clickOnGoToBank(bank);
        new ConfirmationOATHBank(driver)
                .directionTypeBank(bank,env);
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
        new ConfirmationOATHBank(driver)
                .directionTypeBank(bank,env);
        new MFASecurityAccount(driver)
                .ClickTypeVerifyMFA(bank,env)
                .ConfirmMFASecutiyCode(bank,env);
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
        driver.switchTo().defaultContent();
        driver.findElement(By.id("establish")).click();

        new SelectBank(driver)
                .searchBankAmerica(bank,env)
                .clickOnTheBakSearshedAmerica(bank,env);
                //.clickOnGoToBank(bank);
        new ConfirmationOATHBank(driver)
                .directionTypeBank(bank,env);
        JOptionPane.showConfirmDialog(null,"Is it possible to userporal");
        /*new ValidationResult(driver)
                .CheckReturnAcoountPayment(env);

        /*new MFASecurityAccount(driver)
                .ClickTypeVerifyMFA(bank,env)
                .ConfirmMFASecutiyCode(bank,env);
        */
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

