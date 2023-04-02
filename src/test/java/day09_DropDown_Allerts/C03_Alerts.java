package day09_DropDown_Allerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Alerts extends TestBase {
    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
Bir metod olusturun: acceptAlert
1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
 “You successfully clicked an alert” oldugunu test edin.
Bir metod olusturun: dismissAlert
2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin.
Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */
    @Test  //Bir metod olusturun: acceptAlert
    public void acceptAlerts() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        WebElement yazi = driver.findElement(By.xpath("//p[@id='result']"));
        yazi.isDisplayed();
    }

    @Test   //Bir metod olusturun: dismissAlert
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedText = "successfuly";
        Assert.assertFalse(actualText.contains(expectedText));
    }

    //Bir metod olusturun: sendKeysAlert
    @Test
    public void sendKeysAlert() {
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        String mesaj = "Ayse Arzu Battal";
        driver.switchTo().alert().sendKeys(mesaj);
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.cssSelector("p[id='result']")).getText();
        Assert.assertTrue(actualResult.contains(mesaj));
    }

}

