package NTday06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Odev_Actions {

    /*
   “https://www.saucedemo.com” Adresine gidin
   Username kutusuna “standard_user” yazdirin
   Password kutusuna “secret_sauce” yazdirin
   Login tusuna basin
   Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
   Add to Cart butonuna basin
   Alisveris sepetine tiklayin
   Sectiginiz urunun basarili olarak sepete eklendigini control edin
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

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.saucedemo.com");
        Actions actions = new Actions(driver);
        driver.findElement(By.id("user-name"));
        actions.sendKeys(Keys.TAB)
                .sendKeys("standard_user")
                .sendKeys(Keys.TAB)
                .sendKeys("secret_sauce")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        //    Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String urunAdi = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        System.out.println(urunAdi);

        //    Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //    Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //    Sectiginiz urunun basarili olarak sepete eklendigini kontrol edin
        WebElement element = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        if(element.isDisplayed()){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
    }
}
