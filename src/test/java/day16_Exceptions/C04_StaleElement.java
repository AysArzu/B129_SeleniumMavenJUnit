package day16_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElement extends TestBase {
    @Test
    public void staleElementExceptionTest() {

        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum
        driver.navigate().refresh();
        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();//calisti
    }

    @Test
    public void staleElementExceptionTest2() {

        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        driver.navigate().refresh();
        lmsLogin.click();//calismaz refresh yaptigimiz icin adres silinir

    }

    @Test
    public void staleElementExceptionTest3() {

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();

        driver.navigate().back();//techproeducation.com sayfasına geri döndüm.==>Sayfa yeniden yuklendigi icin locator adresi silindi
        lmsLogin.click();
    }

    @Test
    public void staleElementExceptionTest4() {

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();

        driver.navigate().back();//techproeducation.com sayfasına geri döndüm.==>Sayfa yeniden yuklendigi icin locator adresi silindi
        driver.navigate().refresh();
        lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));//Tekrar locate işlemi yaparak lmsLogin objesine yeni adres veriliyor.
        lmsLogin.click();//Çalıştı


    }
    @Test
    public void staleElementExceptionTest5() {

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();

        driver.get("https://www.techproeducation.com");//LMS'e gittikten sonra techproeducation sayfasına geri dönerek sayfayı yenilemiş oluyorum.

        try {//Reklamın çıkma yada çıkmamam ihtimali üzerine try-cath yaarak oluşabilecek noSuchElementException'ı handle ediyoruz.
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        } catch (Exception ignored) {
        }

        lmsLogin.click();//org.openqa.selenium.StaleElementReferenceException
       // driver.findElements() dersek hata firlatmaz bos list verir
    }

    }
