package NTday15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
 /*
https://the-internet.herokuapp.com/dynamic_loading/1
Start buttonuna tıklayın
Hello World! Yazının sitede oldugunu test edin
 */

public class C02_ExplicitWait extends TestBase {
    @Test
    public void explicitWaitTest() {

//      https://the-internet.herokuapp.com/dynamic_loading/1 linkine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//      Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

//      Hello World! Yazının sitede oldugunu test edin
        //driver.findElement(By.xpath("//div[@id='finish']//h4")).isDisplayed()); //Burada implcit wait kullanıldı
        //implicitly wait ile test gecmedi.Explicit wait kullanacagiz.
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));

   //WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        WebElement visibleText =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
            assertTrue(visibleText.isDisplayed());


    }
}
