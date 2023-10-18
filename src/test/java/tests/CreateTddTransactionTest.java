package tests;


import PartsOfGlobex.*;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import suporte.ValidationResult;
import suporte.Web;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "tddFileTestData.csv")

public class CreateTddTransactionTest {
    private WebDriver driver;


    @Test()
    public String testCreateDeferredTransaction(String environment){

        driver = Web.createChrome(environment);
            new SelectMerchantGlobex(driver)
                    .typeIdMerchant("1001168916");
            driver.navigate().refresh();
            new SelectTypeTrx(driver)
                    .choiceTypeTrx("Deferred");
            new InsertAmountTrx(driver)
                    .clickCustomAmount()
                    .inputAmountTrx("0.00");
            new DeveloperOptions(driver)
                    .checkBoxDeveloperOptions()
                    .checkDeveloperOptionCustomData()
                    .typeCustomData()
                    .clickSaveButtomCustomData();
            new SelectEndUser(driver)
                    .choiceEndUser("GB - Freddie Mercury");
            new SelectCurrency(driver)
                    .choiceCurrency("GBP - United Kingdom");
            new SelectBank(driver)
                    .clickLogInToMyBankButtom()
                    .searchNameBank("Demo Bank")
                    .clickOnTheBakSearshed()
                    .clickOnGoToDemoBank();
            new ConfirmationOATHBank(driver)
                    .OAuthBank();
            new SelectBank(driver)
                    .confirmeAccountBank()
                    .confirmCoOwner()
                    .continueMandateData()
                    .confirmMandate();
            String trx = new ValidationResult(driver).CheckResult();



        driver.quit();
        return trx;
    }

}

