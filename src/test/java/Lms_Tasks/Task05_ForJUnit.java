package Lms_Tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class Task05_ForJUnit extends TestBase {
    /*
    -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
    -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
    -Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
    -Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
    -Çıkan alert'te iptal butonuna basınız
    -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
    -Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
    -Çıkan mesajı konsola yazdırınız
    -Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
     */
    @Test
    public void testAlert() throws InterruptedException {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");
        Thread.sleep(3000);
        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.cssSelector("button[onclick='alertbox()']")).click();
        Thread.sleep(3000);
        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        //-Alert with OK & Cancel butonuna basınız ve sonrasında
        // click the button to display a confirm box butonuna basınız
        driver.findElement(By.partialLinkText("Alert with OK &")).click();
        driver.findElement(By.cssSelector("*[onclick='confirmbox()']")).click();
        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();

        //-Alert with Textbox butonuna basınız ve sonrasında
        // click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.partialLinkText("Alert with T")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("*[onclick='promptbox()']")).click();

        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        String message = "Ayse Arzu Battal";
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(Keys.chord(Keys.CONTROL,"a")+Keys.DELETE);
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys(message);
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        //-Çıkan mesajı konsola yazdırınız
        String actualResult = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        System.out.println(actualResult);

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        String expectedResult ="Hello Ayse Arzu Battal How are you today";
        Assert.assertEquals("Beklenen sonuc ile bizdeki sonuc ayni degil",actualResult,expectedResult);

    }


}
