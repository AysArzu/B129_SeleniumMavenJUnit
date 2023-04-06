package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C02_Actions02 extends TestBase {

    /*
    Amazon anasayfasına gidin
    "Account & List" üzerinde bekleyin (mouse over - hover over)
    Açılan menüde "Account" linkine tıklayın
    Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
     */

    @Test
    public void hoverOver() {
        //Amazon anasayfasına gidin
        driver.get("https://amazon.com");

        //    "Account & List" üzerinde bekleyin (mouse over - hover over)
        WebElement hoverOver =  driver.findElement(By.id("nav-link-accountList"));
        Actions actions= new Actions(driver);
        actions.moveToElement(hoverOver).perform();//moveToElement()methodu "hover over" islemini gerceklestirir.

        //    Açılan menüde "Account" linkine tıklayın
        driver.findElement(By.linkText("Account")).click();
        //    Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
        String baslik = driver.findElement(By.xpath("//h1")).getText();
        assertTrue(baslik.contains("Your Account"));
    }
}
