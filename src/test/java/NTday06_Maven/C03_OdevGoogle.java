package NTday06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_OdevGoogle {
    /*
    https://www.google.com/ adresine gidin  3- cookies uyarisini kabul ederek kapatin
    Sayfa basliginin “Google” ifadesi icerdigini test edin
    Arama cubuguna “Nutella” yazip aratin
    Bulunan sonuc sayisini yazdirin
    sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    Sayfayi kapatin
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");

        // cookies uyarisini kabul ederek kapatin
        //  driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();

        //    Sayfa basliginin “Google” ifadesi icerdigini test edin
        String google = driver.getTitle();
        String title = "Google";

        if (google.contains(title)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
        //    Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella" + Keys.ENTER);

        //    Bulunan sonuc sayisini yazdirin
        String result = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        //    sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        String[] rakam = result.split(" ");
        String sayi = rakam[1].replaceAll("\\D", "");

        int sayi2 = Integer.valueOf(sayi);
        String dogruMU = sayi2 > 10000000 ? "Buyuktur" : "Kucuktur";
        System.out.println("10 milyondan " + dogruMU);
    }

    //    Sayfayi kapatin
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }
}
