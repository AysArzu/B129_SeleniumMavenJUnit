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

public class Odev03 {
    /*
    https://www.facebook.com adresine gidin
    Cookies’i kabul edin
    “Create an Account” button’una basin
    “radio buttons” elementlerini locate edin
    Secili degilse cinsiyet butonundan size uygun olani secin

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
        //  https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //    Cookies’i kabul edin
        //Cookies cikmadi

        //    “Create an Account” button’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //    “radio buttons” elementlerini locate edin
        WebElement cinsiyet1 = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement cinsiyet2 = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement custom = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        //    Secili degilse cinsiyet butonundan size uygun olani secin
        cinsiyet1.click();
    }
}
