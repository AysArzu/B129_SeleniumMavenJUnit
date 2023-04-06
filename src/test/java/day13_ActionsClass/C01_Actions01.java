package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.*;

public class C01_Actions01 extends TestBase {
     /*
        https://the-internet.herokuapp.com/context_menu  sitesine gidin
        Kutuya sağ tıklayın
        Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
        Tamam diyerek alert'i kapatın
 */

    @Test
    public void actionsTest() {
        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sağ tıklayın
        //Sag tik islemi icin contextClick() methoduna ihtiyacimiz var. Bunun icin Actions objesi olusturulmalidir.

        //1.Adim Actions objesi olusturun
        Actions actions = new Actions(driver);

        //2. uzerinde islem yapilacak webelementi locate edin
        WebElement box = driver.findElement(By.id("hot-spot"));
        // islemi uygulayin
        actions.contextClick(box).perform();//perform methodu son olarak uygulanmalidir

        //Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
        String text = driver.switchTo().alert().getText();
        assertEquals("You selected a context menu",text);

        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();
    }
}
