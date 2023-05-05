package practice_day06;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_Screenshot extends TestBase {
    // https://www.teknosa.com/ adresine gidin
    // arama cubuguna oppo yazip enter'a basınız
    // sonuc sayisini yazdiriniz
    // ikinci urunun fotografını cekin
    // cikan ikinci urune tiklayiniz
    // iki ArrowDown sayfayı asagiya kaydirin
    // sepete ekleyiniz
    // sepetim'e git tilayiniz
    // "Siparis Ozeti" webelementinin text'ini yazdiriniz
    // Alisverisi tamamlayiniz
    // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
    // driver'i kapatiniz
    @Test
    public void screenshot() throws IOException, InterruptedException {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com");

        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.id("search-input")).sendKeys("oppo" + Keys.ENTER);

        // sonuc sayisini yazdiriniz
        String sayi = driver.findElement(By.xpath("//div[@class='plp-info']")).getText();
        System.out.println(sayi);

//      COOKIES ICIN !!!!
        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cıkmadı");
        }

        // ilk urunun fotografını cekin
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);
        WebElement ilkUrun = driver.findElement(By.xpath("//a[@class='prd-link gowitPlp-js']"));
        File tumSayfa = new File("target/ekranGoruntusu/tumSayfa" + tarih + ".jpeg");
        File gecici = ilkUrun.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(gecici, tumSayfa);
        //driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        // cikan ilk urune tiklayiniz
        ilkUrun.click();
        Thread.sleep(3000);


        // bir PAGE_DOWN sayfayı asagiya kaydirin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);


        // sepete ekleyiniz
        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();
        Thread.sleep(3000);


        // sepetim'e git tilayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        Thread.sleep(3000);


        // "Siparis Ozeti" webelementinin text'ini yazdiriniz
        WebElement siparisOzeti = driver.findElement(By.xpath("//div[text()='Sipariş Özeti']"));
        System.out.println("SİPARİS OZETİ: " + siparisOzeti.getText());
        Thread.sleep(3000);


        // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
        Thread.sleep(3000);


        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
        WebElement teknosayaHosgeldiniz = driver.findElement(By.xpath("//div[text()='Teknosa'ya Hoş Geldiniz']"));
        System.out.println("TEKNOSAYA HOSGELDİNİZ TEXT: " + teknosayaHosgeldiniz.getText());
        Thread.sleep(3000);


    }
}
