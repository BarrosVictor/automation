package tests;

import PartsOfAdminConsole.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import suporte.Web;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "tddAdminConsoleFileTestData.csv")
public class CaptureDepositTransaction {
    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    public void setUp(){
        //String environment = "http://localhost:9002/admin-console/";//local
        //String environment = "https://sandbox.paywithmybank.com/merchant-demo/globex/";//AMER SBX
        //String environment = "https://sandbox.eu.trustly.one/admin-console/transactions";//EMEA SBX
        //driver = Web.createChrome(environment);
    }


    public void testAuthorizeTddTransactions(String idUserAdmConsole,
                                            String passUserAdmConsole,
                                             String environment,
                                             String destinationName
                                            ){

        driver = Web.createChrome(environment);

        new LoginAdminConsole(driver)
                .InsertLogin(idUserAdmConsole)
                .InsertPassword(passUserAdmConsole)
                .ClickLogin();
        new HomeAdminConsole(driver)
                .UpperMenuServices("ACH Processor");
        new AchProcessorFiles(driver)
                .ACHTable(destinationName);
        new HomeAdminConsole(driver)
                .UpperMenuServices("FI Gateway Processor");
        new FiGatewayPro(driver)
                .Jobexecute("ACHProcessor");
        new HomeAdminConsole(driver)
                .UpperMenuManager("Destinations");
        new ACHProConfigDestinations(driver)
                .SelectACHProConfigDestination (destinationName)
                .ACHProChangeExchangeWindowsDestination();
        new HomeAdminConsole(driver)
                .UpperMenuServices("FI Gateway Processor");
        new FiGatewayPro(driver)
                .Jobexecute("ACHProcessor")
                .Jobexecute("UpdateTransactionsStatus")
                .Jobexecute("ACHProcessor");
        driver.quit();
    }


    public void testMakeDepositTransaction(@Param(name="idUserAdmConsole")String idUserAdmConsole,
                                           @Param(name="passUserAdmConsole")String passUserAdmConsole,
                                           String trxId,
                                           String environment){

        driver = Web.createChrome(environment);
        new LoginAdminConsole(driver)
                .InsertLogin(idUserAdmConsole)
                .InsertPassword(passUserAdmConsole)
                .ClickLogin();

        new HomeAdminConsole(driver)
                .ClickOnTrxId(trxId);

        new TransactionStatusScreen(driver)
                .ClickOperations()
                .InsertDepositAmount("1.20")
                .SubmitDeposit()
                .ConfimationSubmitTrxCancelButtom()
                .VerifyOperatiosSuccess("Deposit created with status Authorized.");
        driver.quit();
    }


    public void testMakeCaptureTransaction(@Param(name="idUserAdmConsole")String idUserAdmConsole,
                                           @Param(name="passUserAdmConsole")String passUserAdmConsole,
                                           String trxId,
                                           String environment
                                           ){

        driver = Web.createChrome(environment);

        new LoginAdminConsole(driver)
                .InsertLogin(idUserAdmConsole)
                .InsertPassword(passUserAdmConsole)
                .ClickLogin();

        new HomeAdminConsole(driver)
                .ClickOnTrxId(trxId);

        new TransactionStatusScreen(driver)
                .ClickOperations()
                .InsertCaptureAmount("1.20")
                .SubmitCapture()
                .ConfimationSubmitTrxCancelButtom()
                .VerifyOperatiosSuccess("Capture created with status Authorized.");
        driver.quit();
    }


    public void testMakeCancelTransaction(@Param(name="idUserAdmConsole")String idUserAdmConsole,
                                           @Param(name="passUserAdmConsole")String passUserAdmConsole,
                                           String trxId,
                                           String environment){

        driver = Web.createChrome(environment);

        new LoginAdminConsole(driver)
                .InsertLogin(idUserAdmConsole)
                .InsertPassword(passUserAdmConsole)
                .ClickLogin();

        new HomeAdminConsole(driver)
                .ClickOnTrxId(trxId);

        new TransactionStatusScreen(driver)
                .ClickOperations()
                .InsertCancelationMessage("Cancel Automation")
                .SubmitTrxCancel()
                .ConfimationSubmitTrxCancelButtom()
                .VerifyOperatiosSuccess("Cancelled with success.");
        driver.quit();
    }

    @After
    public void tearDown(){
        driver.quit();

    }
}
