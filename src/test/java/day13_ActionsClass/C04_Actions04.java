package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

/*
https://jqueryui.com/droppable/ adresine gidin
"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
*/
public class C04_Actions04 extends TestBase {
    @Test
    public void dragAndDrop() {
        //https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        Actions actions = new Actions(driver);

        //Sayfada IFrame oldugu icin switch yapiyoruz.
        driver.switchTo().frame(0);
        //source ve target in locate'ini aliyoruz
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(source, target).perform();
    }

    @Test
    public void actionsTest() {
//        https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable");

//        "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //Sayfada iFrame olduğu için "switch" yapıyoruz:
        driver.switchTo().frame(0);

        //Kaynak ve hedef web elementlerini locate ediyoruz:
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.
                clickAndHold(source)//clickAndHold ==> Tiklar ve tutar.
                .moveToElement(target)//moveToElement ==> Mouse'u bir element uzerine tasir.
                .release()//release==> methodu tiklanip tutulan mouse'u birakir.
                .perform();
        //Burada dragAndDroptan farkli olarak islemleri kendimiz belirttik.
        wait(3);
    }

    @Test
    public void dragAndDrop2() {
        //https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        Actions actions = new Actions(driver);

        //Sayfada IFrame oldugu icin switch yapiyoruz.
        driver.switchTo().frame(0);
        //source ve target in locate'ini aliyoruz
        WebElement source = driver.findElement(By.id("draggable"));
        Actions action = new Actions(driver);
        action.
                clickAndHold(source).
                moveByOffset(388, 34).//moveByOffset methodu ile isteğimiz koordinata elementimizi taşıyabiliriz.
                release().
                build().
                perform();

    }

}
