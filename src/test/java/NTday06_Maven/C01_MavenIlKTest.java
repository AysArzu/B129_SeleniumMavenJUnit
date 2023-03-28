package NTday06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlKTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //arama kutusunu locate edelim
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("samsung headphones" + Keys.ENTER);
        //“Samsung headphones” ile arama yapalim
        WebElement sonucSayisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String[] sonuc = sonucSayisi.getText().split(" ");
        System.out.println("Bulunan Sonuc Sayisi = " + sonuc[2]);

        //Lambda ile yazdıralım
        //1-16 of 223 results for "Samsung headphones"
        Arrays.stream(sonucSayisi.getText().split(" ")).skip(2).limit(1).
                forEach(t -> System.out.println("Sonuc Sayisi " + t));
        Arrays.stream(sonucSayisi.getText().split(" ")).limit(3).skip(2).
                forEach(t -> System.out.println("Sonuc Sayisi2 = " + t));

        //Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        //Sayfadaki tum basliklari yazdiralim
        List<WebElement> basliklar = driver.findElements(By.xpath("//h1"));
        for (WebElement each : basliklar
        ) {
            System.out.println(each.getText());
        }
        basliklar.stream().forEach(t -> System.out.println(t.getText()));
        driver.close();
    }
}
