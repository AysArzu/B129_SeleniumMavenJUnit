package bireysel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class C02 extends TestBase {
    @Test
    public void test1() {
        //https://nunzioweb.com/ sitesine git
        driver.get("https://nunzioweb.com/");
        //sitenin gorunur oldugunu test et
        System.out.println(driver.getTitle());
        assertTrue(driver.getTitle().contains("Nunzio"));


        ////soldaki photo page tıklayın
        driver.findElement(By.xpath("(//td[@onmouseout='cellout1(this)'])[8]")).click();

        ////ana sayfaya geri donun
        driver.navigate().back();
        ////"A television show that Nunzio always liked was" yazan kisimda play tusuna basin
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//button[@title='Play/Pause']")).click();

        //// parent iframe e geri donun
        driver.switchTo().defaultContent();

        ////Navigation menusunun elemanlarını yazdirin
        List<WebElement> navigations = driver.findElements(By.xpath("//td[text()='NAVIGATION']"));
        navigations.forEach(t -> System.out.println(t.getText()));
        ////How to Access Free Yahoo! Mail with Outlook linkini tiklayin
        driver.findElement(By.partialLinkText("How to Access Free Yahoo!")).click();
        ////ilk sayfaya geri donun
        switchToWindow(0);
    }

}
