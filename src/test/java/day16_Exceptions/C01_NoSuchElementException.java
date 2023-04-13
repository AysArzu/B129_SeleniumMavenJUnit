package day16_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void noSuchElementExceptionTest() {
        driver.get("https://techproeducation.com");
       // driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum
      //  driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA"+ Keys.ENTER); //dogrusu bu
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum
        driver.findElement(By.xpath("//input[@type='searrch']")).sendKeys("QA"+ Keys.ENTER);//NoSuchElementException
        //Web element bulunamayinca alinir.

    }
}
