package bireysel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Task04_ForJUnit {
    /*
        -Amazon sayfasına gidelim
        -Arama Kutusundaki Dropdown menuyu yazdıralım
        -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        Not: Select Class'ı kullanalım
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
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void dropDown() {
        // -Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        // -Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement dropBox = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

        Select select = new Select(dropBox);
        List<WebElement> liste = select.getOptions();
        liste.stream().skip(1).forEach(t -> System.out.println(t.getText()));

        // -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //  başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

        for (int i = 1; i <= 6; i++) {
            WebElement dropDown = driver.findElement(By.cssSelector("select[aria-describedby='searchDropdownDescription']"));
            Select select1 = new Select(dropDown);
            select1.selectByIndex(i);
            driver.findElement(By.id("nav-search-submit-button")).click();
            System.out.println(i + ". sayfa basligi: " + driver.getTitle());
            driver.navigate().back();
        }
        /*
        2.yol
         int sayac=1;
        for (WebElement w:select.getOptions()) {
            Select option = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            option.selectByIndex(sayac);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            sayac++;
            if (sayac>=6){
                break;
            }
        }
         */
    }
}
