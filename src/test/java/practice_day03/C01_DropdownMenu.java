package practice_day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropdownMenu extends TestBase {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin

    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://amazon.com");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);

        // dropdown'dan "Books" secenegini secin
        select.selectByVisibleText("Books");

        // arama cubuguna "Java" aratın
        WebElement aramaCubugu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaCubugu.sendKeys("Java"+ Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String aramaSonucYazisi = aramaSonucElementi.getText();
        Assert.assertTrue(aramaSonucYazisi.contains("Java"));
    }

}
