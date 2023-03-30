package day08;
import static org.junit.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev01 {
    //1)https://www.youtube.com adresine gidin
    //2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //=> Sayfa başlığının “YouTube” oldugunu test edin
    //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1)https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    //2)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    @Test
    public void test01() {
        //=> Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        assertEquals(actualTitle,expectedTitle);
        System.out.println(driver.getTitle());
    }
    @Test
    public void test02() {
        //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement actualLogo= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        System.out.println(actualLogo.isDisplayed());
    }
    @Test
    public void test03() {
        //○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='search']"));
        System.out.println(searchBox.isEnabled());
    }

    @Test
    public void test04() {
        //○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String expectedTitle ="youtube";
        assertEquals("sayfa basligi youtube degildir" ,actualTitle,expectedTitle);
    }
}
