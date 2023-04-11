package Lms_Tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task08 extends TestBase {
    @Test
    public void test() {
        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        driver.switchTo().frame(0);
        wait(3);


        WebElement first = driver.findElement(By.xpath("//span[@tabindex='0']"));
        WebElement second = driver.findElement(By.xpath("(//span[@tabindex='0'])[2]"));
        WebElement third = driver.findElement(By.xpath("(//span[@tabindex='0'])[3]"));
        Actions actions = new Actions(driver);
        actions.
                clickAndHold(first)
                .moveByOffset(+20, 0)
                .release()
                .perform();

        actions.clickAndHold(second)
                .moveByOffset(-170, 0)
                .release()
                .perform();
        wait(3);
        actions.clickAndHold(third).
                moveByOffset(-65, 0).
                release().
                perform();

        actions.clickAndHold(second)
                .moveByOffset(350, 0)
                .release()
                .perform();

//       -Sarı olduğunu test edelim
        WebElement sari = driver.findElement(By.xpath("//div[@style='background-color: rgb(255, 255, 6);']"));
        assertTrue(sari.isDisplayed());


    }
}
