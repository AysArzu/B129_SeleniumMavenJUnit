package day08;
import static org.junit.Assert.assertFalse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
          2)https://amazon.com adresinegidin
          3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleriyapin
            ○ title Test  => Sayfa başlığının “Amazon” oldugunu test edin
            ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
            ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
            ○ wrongTitleTest => Sayfa basliginin “amazon” olmadigini dogrulayin
     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2)https://amazon.com adresine gidin
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    // 3)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    @Test
    public void test01() {
        // ○ title Test  => Sayfa başlığının “Amazon” kelimesini icerip icermedigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        boolean iceriyorMu = actualTitle.contains(expectedTitle);
        Assert.assertTrue(iceriyorMu);//True
    }




    @Test
    public void test02() {
        // ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        System.out.println(logo.isDisplayed());//true
    }

    @Test
    public void test03() {
        // ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        System.out.println(searchBox.isEnabled());
    }

    @Test
    public void test04() {
        // ○ wrongTitleTest => Sayfa basliginin “amazon” icermedigini dogrulayin
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";
      assertFalse(actualTitle.contains(expectedTitle));
    }
}
