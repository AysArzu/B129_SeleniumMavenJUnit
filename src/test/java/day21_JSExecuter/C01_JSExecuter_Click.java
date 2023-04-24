package day21_JSExecuter;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.*;

public class C01_JSExecuter_Click extends TestBase {
    /*
        http://www.uitestpractice.com/Students/Form sayfasına git
        Formu doldur
        Submit tuşuna tıkla
        Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
*/
    @Test
    public void clickByJSTest() {
//        http://www.uitestpractice.com/Students/Form sayfasına git
        driver.get("http://www.uitestpractice.com/Students/Form");

//        Formu doldur
        driver.findElement(By.id("firstname")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.id("lastname")).sendKeys(Faker.instance().name().lastName());
        driver.findElement(By.id("email")).sendKeys(Faker.instance().internet().emailAddress());

//        Submit tuşuna tıkla
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        //submitButton.click();==>Selenium click() calismadi. ElementClickInterceptedException verdi.
        //JS Executer deneyecegim.
        //Driver'i JavascriptExecuter classina "cast" ediyorum
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//        //executeScript() methodu ile uygun scripti calistiriyorum.
//        jse.executeScript("arguments[0].click();", submitButton);

        //clickByJS methodu olusturarak gerekli yerlerde tiklama yapabiliriz.
        clickByJS(submitButton);//TestBase'de olusturdum

//        Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
        assertEquals("http://www.uitestpractice.com/Students/Form?", driver.getCurrentUrl());

    }
}
