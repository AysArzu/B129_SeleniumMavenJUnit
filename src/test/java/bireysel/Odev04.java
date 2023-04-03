package bireysel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Odev04 extends TestBase {
    //● https://the-internet.herokuapp.com/iframe adresine gidin.
    //● Bir metod olusturun: iframeTest
    //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    //○Text Box’a “Merhaba Dunya!” yazin.
    //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
    //oldugunu dogrulayin ve konsolda yazdirin


    //● Bir metod olusturun: iframeTest
    @Test
    public void iframeTest() {
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement yazi = driver.findElement(By.xpath("//h3"));
        System.out.println(yazi.isDisplayed());

        //○Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame("mce_0_ifr");

        WebElement textbox = driver.findElement(By.xpath("//p"));
        textbox.clear();
        textbox.sendKeys("Merhaba Dunya!");

        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve
        // konsolda yazdirin
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.partialLinkText("Elemental S")).isDisplayed());


    }
}

