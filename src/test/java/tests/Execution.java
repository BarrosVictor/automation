package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Execution {
    private WebDriver driver;
    @Test
    public void Execution(){
        String environmentA = "https://sandbox.eu.trustly.one/merchant-demo/globex/";
        String environmentB = "https://sandbox.eu.trustly.one/admin-console/";
        String userId = "victor.barros";//sandboxEMEA
        String passId = "yd4{[D#22Xft@{@v7p";//sandboxEMEA

        /*String environmentA = "http://localhost:7000/merchant-demo/globex/";
        String environmentB = "http://localhost:9002/admin-console/";
        String userId = "admin";//local
        String passId = "superadmin";//local*/

        CreateTddTransactionTest a = new CreateTddTransactionTest();
        String idTrx = a.testCreateDeferredTransaction(environmentA);
        CaptureDepositTransaction b = new CaptureDepositTransaction();
        b.testAuthorizeTddTransactions(userId,passId,environmentB);

        b.testMakeDepositTransaction(userId,passId,idTrx,environmentB);

        b.testMakeCaptureTransaction(userId,passId,idTrx,environmentB);

        b.testMakeCancelTransaction(userId,passId,idTrx,environmentB);
    }

}
