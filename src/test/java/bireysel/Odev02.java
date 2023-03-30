package bireysel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.IconUIResource;
import java.time.Duration;

public class Odev02 {
    /*
    - http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
    - Add Element butonuna 100 defa basınız
    - 100 defa basıldığını test ediniz
    - 90 defa delete butonuna basınız
    - 90 defa basıldığını doğrulayınız
    - Sayfayı kapatınız
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
        //- Sayfayı kapatınız
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() {
        //- http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //- Add Element butonuna 100 defa basınız
        int count = 0;
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        for (int i = 0; i < 100; i++) {
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
            count++;

        }
        //- 100 defa basıldığını test ediniz
        //  Assert.assertEquals(count, 100);
        if (count == 100) {
            System.out.println("Add button'u 100 kere tiklandi");
        } else {
            System.out.println("Add button'u 100 kere tiklanmadi.");
        }
        //- 90 defa delete butonuna basınız
        // Assert.assertEquals(counter, 90);
        driver.findElement(By.xpath("//button[text()='Add Element']"));
        int counter = 0;
        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        for (int i = 0; i <90 ; i++) {
            driver.findElement(By.xpath("//button[text()='Delete']")).click();
        counter++;

        }
        //- 90 defa basıldığını doğrulayınız
        if(counter==90){
            System.out.println("90 defa delete button'una basildi");

        }else {
            System.out.println("90 defa delete button'una basilmadi");
        }

    }
}
