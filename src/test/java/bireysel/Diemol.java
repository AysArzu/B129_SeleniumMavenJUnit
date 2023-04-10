package bireysel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.*;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Diemol extends TestBase {
    @Test
    public void name() {
        // 1.) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        // 2.) Berlin'i 3 farkli relative locator ile locate edin

        // 3 ) Relative locator'larin dogru calistigini test edin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        WebElement nyc = driver.findElement(By.id("pid3_thumb"));
        WebElement sailor = driver.findElement(By.id("pid11_thumb"));

        WebElement bayArea= driver.findElement(By.id("pid8_thumb"));
        WebElement berlin = driver.findElement(with(By.tagName("img")).above(sailor).below(nyc).toLeftOf(bayArea));
        berlin.click();

        // 3 ) Relative locator'larin dogru calistigini test edin
        String simdikiidDegeri = berlin.getAttribute("id");
        assertEquals("pid7_thumb", simdikiidDegeri);

    }
}
