package Lms_Tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Dummy extends TestBase {
    @Test
    public void test08() throws InterruptedException {
        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        driver.switchTo().frame(0);
        WebElement red = driver.findElement(By.xpath("//div[@id='red']/span"));
        WebElement green = driver.findElement(By.xpath("//div[@id='green']/span"));
        WebElement blue = driver.findElement(By.xpath("//div[@id='blue']/span"));
        Actions actions = new Actions(driver);
        actions.
                clickAndHold(green).
                moveByOffset(-170,0).
                release().
                perform();
        actions.
                clickAndHold(blue).
                moveByOffset(-70,0).
                release().
                perform();
        Thread.sleep(3000);
        actions.
                clickAndHold(green).
                moveByOffset(350,0).
                release().
                perform();
        //-Sarı olduğunu test edelim
        String rgba = driver.findElement(By.xpath("//div[@id='swatch']")).getCssValue("background-color");
        Assert.assertEquals("rgba(255, 255, 1, 1)",rgba);

    }}
