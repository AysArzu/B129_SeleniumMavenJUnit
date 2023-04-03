package day11_IFrame_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle2 extends TestBase {
    @Test
public void newWindowTest(){
        //https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        String techproWindowHandle = driver.getWindowHandle();
        System.out.println(driver.getTitle());
        Assert.assertEquals("Techpro Education | Online It Courses & Bootcamps",driver.getTitle());

        //Window 2 de youtube a gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://youtube.com");
        String youTuBeWindowHandle = driver.getWindowHandle();

        //Window 3 de linkedin a gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

        //techpro ya gecelim
        driver.switchTo().window(techproWindowHandle);
        //youtube ya gecelim
        driver.switchTo().window(youTuBeWindowHandle);
        //linkedIn e gecelim
        driver.switchTo().window(linkedinWindowHandle);
    }
}
