package day14_JavaFaker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
/*
"https://techproeducation.com/" gidin
İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
 */
public class C01_Actions extends TestBase {
    @Test
    public void actions() {
        //"https://techproeducation.com/" gidin
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("(//i[@class='eicon-close'])")).click();//reklam kapattik

        //İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
    WebElement searchBox =  driver.findElement(By.xpath("//input[@type='search']"));
        Actions actions =  new Actions(driver);
        actions.
                keyDown(searchBox,Keys.SHIFT)//Arama kurusu uzerinde SHIFT tusuna basili tut
                .sendKeys("techpro").//SHIFT basili sekilde techpro yazisizi gonder
                keyUp(Keys.SHIFT).//SHIFT tusuna basma islemini sonlandir
                sendKeys(" education"+Keys.ENTER).//SHIFT tusuna basmadan "education" kelimesini yolla ve ENTER tusuna bastik
                build().
                perform();
    }
}
