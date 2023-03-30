package practice_day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        // https://www.amazon.com/ adresine gidin
        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        // sayfayi kapatiniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement aramaKutusu =  driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        String actualName = aramaKutusu.getTagName();
        String expectedTagname = "input";
       // Assert.assertEquals(actualName,expectedTagname);
        if(actualName.equals(expectedTagname)){
            System.out.println("Tagname input");
        }else{
            System.out.println("Tagname input degil");
        }
        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        String nameValue = aramaKutusu.getAttribute("name");
        String expectedTagValue = "field-keywords";
        if(nameValue.equals(expectedTagValue)){
            System.out.println("Atribute degeri field-keywords");
        }else {
            System.out.println("Atribute degeri field-keywords degildir.");
        }
        // sayfayi kapatiniz
        driver.close();
    }
}
