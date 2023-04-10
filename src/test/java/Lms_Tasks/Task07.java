package Lms_Tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task07 extends TestBase {
    //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
    //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
    //- Çizimden sonra clear butonuna basınız
    //- Sayfayi kapatiniz

    @Test
    public void ekranaYaziYazma() {
        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        Actions actions = new Actions(driver);
     /*   String source= driver.findElement(By.xpath("//canvas["))
        actions.
                clickAndHold(source).
                moveByOffset(388, 34).//moveByOffset methodu ile isteğimiz koordinata elementimizi taşıyabiliriz.
                release().
                build().
                perform();*/
        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        // Canvas öğesini bulma
        WebElement source = driver.findElement(By.cssSelector("canvas"));

        // Çizgi çizme işlemi
        Actions action = new Actions(driver);
        action.moveToElement(source, 30, 30)
                .clickAndHold()
                .moveByOffset(50, 0)
                .moveByOffset(-25, 50)
                .moveByOffset(-25, -50)
                .moveByOffset(0, 25)
                .release()
                .perform();

        //- Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//button[text()='Clear']")).click();

        //- Sayfayi kapatiniz
        driver.close();
    }
}
