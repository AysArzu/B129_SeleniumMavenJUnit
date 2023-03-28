package NTday06_Maven;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C02_MavenClasswork {
    /*\
        http://zero.webappsecurity.com sayfasina gidin
    Signin buttonuna tiklayin
    Login alanine  “username” yazdirin
    Password alanine “password” yazdirin
    Sign in buttonuna tiklayin
    Pay Bills sayfasina gidin
    amount kismina yatirmak istediginiz herhangi bir miktari yazin
    tarih kismina “2020-09-10” yazdirin
    Pay buttonuna tiklayin
    “The payment was successfully submitted.” mesajinin ciktigini control edin
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //Login alanine  “username” yazdirin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");
        //Password alanine “password” yazdirin
        WebElement pass = driver.findElement(with(By.tagName("input")).below(login));
        pass.sendKeys("password");


        //Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.navigate().back();
        //Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("100");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB)
                .sendKeys("2023-03-27")//tarih kismina “2020-09-10” yazdirin
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();  //Pay buttonuna tiklayin


        //“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement text = driver.findElement(By.xpath("*[text()='The payment was successfully submitted.'"));
        if (text.isDisplayed()) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");

        }
        driver.close();
    }
}
