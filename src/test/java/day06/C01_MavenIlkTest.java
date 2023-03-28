package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    /*
    1.https://www.amazon.com/ sayfasına gidelim
    2.Arama kutusunu locate edelim
    3.“Samsung headphones” ile arama yapalım
    4.Bulunan sonuç sayısını yazdıralım
    5.İlk ürünü tıklayalım
    6.Sayfadaki tüm başlıkları yazdıralım
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1.https://www.amazon.com/ sayfasına gidelim
        driver.get("https://amazon.com");

        //        Arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

//        "Samsung headphones" ile arama yapalım
        aramaKutusu.sendKeys("Samsung headphones");
        aramaKutusu.submit();//Enter'a bastık

//        Bulunan sonuç yazısı yazdıralım
        WebElement aramaSonucu = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println("aramaSonucu = " + aramaSonucu.getText());

        //        İlk ürünü tıklayalım
        //Tüm arama sonucu ürünleri list içini koyup ilk elemanı tıklıyoruz
        List<WebElement> urunlistesi = driver.findElements(By.xpath("//img[@class='s-image']"));
        urunlistesi.get(0).click();

//        Sayfadaki tüm başlıkları yazdıralım
        List<WebElement> basliklar = driver.findElements(By.xpath("//h1"));
//        for (WebElement w : basliklar){
//            System.out.println(w.getText());
//        }

        basliklar.forEach(t -> System.out.println(t.getText()));
        //Sayfayi kapat
        driver.close();
    }


}
