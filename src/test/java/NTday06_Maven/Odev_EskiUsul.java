package NTday06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Odev_EskiUsul {
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
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //    Username kutusuna “standard_user” yazdirin
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        //    Password kutusuna “secret_sauce” yazdirin
        driver.findElement(with(By.tagName("input")).below(userName)).sendKeys("secret_sauce");

        //    Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

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
        //    Sayfayi kapatin
        driver.close();
    }
}
