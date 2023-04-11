package day15_FileUpload_Wait;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C03_FluentWait extends TestBase {
    @Test
    public void fluentWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test edin
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofDays(20)). //Fluent icin mac sureyi belirtir
                pollingEvery(Duration.ofSeconds(4)).//Her ic saniyede bir webElementi kontrol eder
                withMessage("Ignore Exception").//zorunlu degil
                ignoring(NoSuchElementException.class);//Exception'i handle eder

        WebElement helloWordText1 = driver.findElement(By.xpath("(//h4)[2]"));
        wait.until(ExpectedConditions.visibilityOf(helloWordText1));
        assertTrue(helloWordText1.isDisplayed());

        /*
        Thread.Sleep: Javadan gelen bu bekleme ile belirttiğimiz süre kadar kodları bekletir
        Implicitly Wait: Sayfadaki tüm webelementler için max süre kadar sayfanın yüklemesini bekler
        Explicit Wait: Belirli bir koşul gerçekleşene kadar belirttiğimiz süre boyunca driver'ın beklemesini sağlar
        Fluent Wait: Belirli bir koşul gerçeklesene kadar belirttiğimiz aralıklarla beklemeye devam eder
         */
    }
}
