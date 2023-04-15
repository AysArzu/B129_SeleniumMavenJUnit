package day16_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_StaleElementAlistirma extends TestBase {
    @Test
    public void StaleElementReferanceExceptionTest5() {
        /*
        NOT:StaleElementReferanceException hatası almamız gerekiyor
        //Amazon sayfasına gidelim
        //iphone aratalım
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        //Sayfayı kapatalım
         */
        //NOT:StaleElementReferanceException hatası almamız gerekiyor
//Amazon sayfasına gidelim
        driver.get("https://amazon.com");

//iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

//Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        List<WebElement> urunler = driver.findElements(By.xpath("//h2"));

        for (int i = 0; i < urunler.size(); i++) {
            urunler.get(i).click();
            wait(3);
            driver.navigate().back();
            if (i == 4) {
                break;
            }
        }

    }

    @Test
    public void StaleElementReferanceExceptionTest6() {
        /*
        NOT:Exception almadan doğru şekilde yapalım
        //Amazon sayfasına gidelim
        //iphone aratalım
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        //Sayfayı kapatalım
         */
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

//iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

//Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        List<WebElement> urunler = driver.findElements(By.xpath("//h2"));

        for (int i = 0; i < urunler.size(); i++) {
            urunler.get(i).click();
            wait(3);
            driver.navigate().back();
            if (i == 4) {
                break;
            }     urunler = driver.findElements(By.xpath("//h2"));

        }
    }
}