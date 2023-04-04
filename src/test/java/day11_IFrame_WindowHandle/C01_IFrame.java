package day11_IFrame_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_IFrame extends TestBase {
    /*
https://the-internet.herokuapp.com/iframe sayfasına gidiniz
Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
Textbox içindeki yazıyı siliniz.
Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
 */

    @Test
    public void iframe01(){

        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String yazi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(yazi.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        //Texbox iframe icinde yer aldigi icin once iframe e gecis yapmaliyiz
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        //Webelementimiz default page icerisinde yer aldigi icin once driver'i iFrame disina yani sayfamiza alalim
        //driver.switchTo().parentFrame(); Ust frame'e yani frame disina cikar
        //driver.navigate().refresh(); Bu methodla sayfayi yeniledigimiz icin ilk bolume tekrar gecmis oluruz. Ama gonderdigimiz yazi silinir
        driver.switchTo().defaultContent();
        WebElement footer = driver.findElement(By.partialLinkText("Elemental S"));
        System.out.println(footer.isDisplayed());


    }
}
