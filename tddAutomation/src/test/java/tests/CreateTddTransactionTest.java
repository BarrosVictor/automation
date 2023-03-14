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

    @Rule
    public TestName test = new TestName();
    /*@Before
    public void setUp(){
        //String environment = "http://localhost:9002/admin-console/";//local
        String environment = "http://localhost:7000/merchant-demo/globex/";//local globex
        //String environment = "https://sandbox.paywithmybank.com/merchant-demo/globex/";//AMER SBX
        //String environment = "https://sandbox.eu.trustly.one/merchant-demo/globex/";//EMEA SBX
        driver = Web.createChrome(environment);
    }*/

    @Test()
    public String testCreateDeferredTransaction(String environment, String idMerchant){

        driver = Web.createChrome(environment);
        String idTrx;
        new SelectMerchantGlobex(driver)
                .typeIdMerchant(idMerchant);
        new SelectTypeTrx(driver)
                .choiceTypeTrx("Deferred");
        new InsertAmountTrx(driver)
                .clickCustomAmount()
                .inputAmountTrx("0.00");
        new SelectEndUser(driver)
                .choiceEndUser("GB - Freddie Mercury");
        new SelectCurrency(driver)
                .choiceCurrency("GBP - United Kingdom");
        new DeveloperOptions(driver)
                .checkBoxDeveloperOptions()
                .checkDeveloperOption()
                .typeCustomData()
                .clickSaveButtomCustomData();
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
        idTrx = new ValidationResult(driver).CheckResult();
        driver.quit();
        return idTrx;
    }
    @After
    public void tearDown(){
        driver.quit();

    }
}

