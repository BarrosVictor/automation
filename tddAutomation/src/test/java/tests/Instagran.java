package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import suporte.SleepClass;
import suporte.Web;

public class Instagran {

    private WebDriver driver;

    @Test
    public void enviarMsg(){
        driver = Web.createChrome("https://www.instagram.com/direct/t/340282366841710300949128225356116306832");
        for (int i = 0; i <= 800; i++) {
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div/div[2]/div/section/div/div/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/textarea")).sendKeys("Me envia essa musica pf, veja minha mensagem e me responda kkkkkkk. Não me bloqueia!");
            new SleepClass().SleepTime(2000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div/div[2]/div/section/div/div/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/textarea")).sendKeys(Keys.ENTER);
            new SleepClass().SleepTime(2000);
        }
    }
}
