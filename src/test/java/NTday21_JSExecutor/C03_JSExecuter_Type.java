package NTday21_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_Type extends TestBase {
         /*
        Techpro education ana sayfasina git
        Arama kutusuna QA yaz
         */

    @Test
    public void typeTest() {
        driver.get("https://techproeducation.com");
        wait(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapattik

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@name='s']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        /*
        Bazi giris kutulari normal sendKeys() methodu ile metin veri gonderilmesine izin vermez. Bu
        gibi durumlerde asagidaki ornekteki gibi JSExecuter kullanilir.
         */
        js.executeScript("arguments[0].value='QA'", aramaKutusu);
        typeWithJS("QA", aramaKutusu);
        aramaKutusu.submit();
        /*
        Eger js.executeScript("arguments[0].value='QA'", aramaKutusu); bu kullanimdaki gibi metin gonderemezsek
        asagidaki ornekteki gibi value atribute'ne deger atayabiliriz
         */

    }
}
