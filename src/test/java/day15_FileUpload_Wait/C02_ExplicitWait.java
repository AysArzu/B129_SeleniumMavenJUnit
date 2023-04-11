package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {
    /*
        https://the-internet.herokuapp.com/dynamic_loading/1
        Start buttonuna tıklayın
        Hello World! Yazının sitede oldugunu test edin
         */
    @Test
    public void explicitWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();
        //Assert.assertTrue(driver.findElement(By.xpath("(//h4)[2]")).isDisplayed());
        //Bir webelementin görünürlüğünü implicitly wait ile bu sayfada çözemedik

        //Hello World! Yazının sitede oldugunu test edin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement helloWordText = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("(//h4)[2]")));

        Assert.assertTrue(helloWordText.isDisplayed());

        //2.Yol
        WebElement helloWordText1 = driver.findElement(By.xpath("(//h4)[2]"));
        wait.until(ExpectedConditions.visibilityOf(helloWordText1));
        Assert.assertTrue(helloWordText1.isDisplayed());

        //2 temel wait vardir.
        //        1- Java based wait == Thread.sleep()
        //        2- Selenium based waits
        //            2.1- implicitly wait
        //        Obje olusturmaksizin driver.manage.timeouts... seklinde olusturabiliriz.
        //            2.2- explicitly wait
        //        WebDriverWait class'indan obje olusturmaliyiz. Constructor'in icine driverimizi ve Duration koymaliyiz.
    }


}
