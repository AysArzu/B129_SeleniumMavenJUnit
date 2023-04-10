package NTday14_FakerClass_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void actions() {
        /*
    "https://techproeducation.com/" gidin
    İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
     */

        //"https://techproeducation.com/" gidin
        driver.get("https://techproeducation.com");
        driver.findElement(By.cssSelector("i[class='eicon-close']")).click();

        //İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        Actions actions = new Actions(driver);
        actions.
                keyDown(searchBox, Keys.SHIFT).//Arama kutusu uzerinde shift tusuna basili tutar
                sendKeys("techpro").
                keyUp(Keys.SHIFT).//shift tusuna basma islemi sonlanir
                sendKeys(" education" + Keys.ENTER).
                perform();
        //Sayfayi Richmond College Enrollment Form linkine kadar scroll yapalim
        WebElement richmondCollege = driver.findElement(By.xpath("(//h3//a)[9]"));
        actions.scrollToElement(richmondCollege).perform();
        //scrollToElement() methodu ile locate ettiginiz bir WebElemente kadar
        // yani o element gorunene kadar scroll yapar.

    }
}
