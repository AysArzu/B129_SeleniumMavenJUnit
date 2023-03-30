package bireysel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev01 {
    /*
    *** Aşağıdaki Task'i Junit framework'u ile yapınız
    - ebay sayfasına gidiniz
    - electronics bölümüne tıklayınız
    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    - Her sayfanın sayfa başlığını yazdıralım
    - sayfayı kapatalım
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {
        //- sayfayı kapatalım
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() {
        // - ebay sayfasına gidiniz
        driver.get("https://ebay.com");

        //    - electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")).click();

        //    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım ve
        //      Her sayfanın sayfa başlığını yazdıralım
        List<WebElement> resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        for (int i = 1; i <= resimler.size(); i++) {
            String imageXpath = "(//img[@width='225' and @height='225'])[" + i + "]";
            WebElement image = driver.findElement(By.xpath(imageXpath));
            image.click();
            System.out.println(i + " . Title:" + driver.getTitle());
            driver.navigate().back();
        }
/*
            for (int i = 0; i <24 ; i++) {
            List <WebElement> resimler = driver.findElements(By.xpath("//img[@width='225'and @height='225']"));
            resimler.get(i).click();
            System.out.println(i + " . Title:" + driver.getTitle());
            driver.navigate().back();
        }
 */


    }
}
