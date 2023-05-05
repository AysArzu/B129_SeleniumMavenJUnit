package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev02_YanlisEmailTesti {
    //1.Bir Class olusturalim YanlisEmailTesti
    //2.https://automationexercise.com/ sayfasina gidelim
    //3.Signup/Login butonuna basalim
    //4.Email kutusuna @isareti olmayan bir mail yazip enter'a
    //bastigimizda giriş yapılamadığını test edelim
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01(){
        //2.http://automationexercise.com sayfasina gidelim
        driver.get("https://automationexercise.com");
        //3.Signup/Login butonuna basalim
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

    }


    @Test
    public void test02() {
        //4.Email kutusuna @isareti olmayan bir mail yazip enter'a
        //bastigimizda giriş yapılamadığını test edelim
        String title1= driver.getTitle();
        WebElement loginBox= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        loginBox.sendKeys("istanbul");
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        String title2=driver.getTitle();
        Assert.assertEquals(title1, title2);
       /*
        WebElement logged = driver.findElement(By.xpath(" //a[text()=' Logged in as ']"));
        System.out.println(!logged.isDisplayed());
        */
    }
}
