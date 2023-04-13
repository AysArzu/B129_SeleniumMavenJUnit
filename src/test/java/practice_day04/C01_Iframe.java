package practice_day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C01_Iframe extends TestBase {
    // https://html.com/tags/iframe sayfasına gidiniz
    // Videoyu görecek kadar asagiya ininiz
    // Videoyu izlemek icin Play tusuna basiniz
    // Videoyu calistirdiginizi test ediniz
    // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
    @Test
    public void Iframe() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//a[@class='ytp-impression-link']")).click();
     //   actions.sendKeys(Keys.PAGE_DOWN).perform();
     //   driver.findElement(By.xpath("//span[text()='Accept all']")).click();
        // Videoyu calistirdiginizi test ediniz

        assertTrue(driver.getTitle().contains("Using The HTML Tag To Create"));

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement yazi= driver.findElement(By.id("Powerful_but_easy_to_misuse"));
        assertTrue(yazi.isDisplayed());
    }
}
