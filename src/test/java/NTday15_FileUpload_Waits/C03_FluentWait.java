package NTday15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C03_FluentWait extends TestBase {
     /*
https://the-internet.herokuapp.com/dynamic_loading/1
Start buttonuna tıklayın
Hello World! Yazının sitede oldugunu test edin
 */

    @Test
    public void fluentWaitTest() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        //Hello World! Yazının sitede oldugunu test edin
        //Fluent wait'in WebDriverWait'ten farki wait objesinin olusturulmasinda ortaya cikar.
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(4)).//max bekleme suresi
                pollingEvery(Duration.ofSeconds(3)).//Deneme araliklari:Her 3 sn de bir bulma deneme yapar
                withMessage("Ignore Exception").//zorunlu degil. Mesaj yazdirilabilir
                ignoring(TimeoutException.class).ignoring(NoSuchElementException.class);//zorunlu degil. Exception handle edilebilir
        WebElement visibleText =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        assertTrue(visibleText.isDisplayed());

    }
}
