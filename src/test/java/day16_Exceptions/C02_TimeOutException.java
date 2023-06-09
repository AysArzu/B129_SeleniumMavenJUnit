package day16_Exceptions;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    @Test
    public void timeOutException() {

        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Yanlış Locator")));//org.openqa.selenium.TimeoutException
        //TimeoutException explicit wait kullanımında web element bulunamadığı zaman alınır.


    }

    @Test
    public void timeOutException2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));//bilerek az saniye koyduk timeoutexception almak icin
         boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='finish']//h4"),"Hello World!"));
        //locator dogru ama yeterli bekleme suresi olmadigi icin TimeOutException aldik
        System.out.println(isTrue);

    }
}
