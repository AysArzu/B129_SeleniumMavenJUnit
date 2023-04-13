package practice_day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C02_WindowHandle extends TestBase {

    // 1- https://www.amazon.com sayfasina gidelim
    // 2- url'in 'amazon' icerdigini test edelim
    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    // 4- title'in 'Best Buy' icerdigini test edelim
    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    // 6- arama sonuclarının 'Java' icerdigini test edelim
    // 7- ikinci sayfaya(bestbuy) donelim
    // 8- logonun gorundugunu test edelim
    @Test
    public void windowHandle() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        // 2- url'in 'amazon' icerdigini test edelim
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("amazon"));
        String first = driver.getWindowHandle();
        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        // 4- title'in 'Best Buy' icerdigini test edelim
        String title = driver.getTitle();
        assertTrue(title.contains("Best Buy"));
        String second = driver.getWindowHandle();
        wait(3);
        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(first);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        // 6- arama sonuclarının 'Java' icerdigini test edelim
        String text = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        assertTrue(text.contains("Java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(second);
        wait(3);
        // 8- logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
        assertTrue(logo.isDisplayed());
    }
}
