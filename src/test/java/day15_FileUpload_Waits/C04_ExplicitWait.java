package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C04_ExplicitWait extends TestBase {
    /*
https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
Add tuşuna basın
"It's gone!" yazısını doğrulayın
 */
    @Test
    public void explicitWait() {
        //https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove tusuna basin
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //"It's gone!" yazısını doğrulayın
        assertTrue(driver.findElement(By.id("message")).isDisplayed());
        //Explicit Wait kullanma geregi yoktur. Implicit wait yeterlidir.
        //Explicit wait bazi ozel durumler icin kullanilir


    }
}
