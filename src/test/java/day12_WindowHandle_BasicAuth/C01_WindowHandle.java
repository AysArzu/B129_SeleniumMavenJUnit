package day12_WindowHandle_BasicAuth;

import static org.junit.Assert.*;


import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandle extends TestBase {
   /*
        https://www.techproeducation.com adresine gidiniz
        Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        Tab 2'de https://www.youtube.com sayfasını açınız
        Tab 3'te https://www.linkedin.com sayfasını açınız
        techproeducation sayfasına geçiniz
        youtube sayfasına geçiniz
        linkedIn sayfasına geçiniz
 */


    @Test
    public void newTabTest() {
        //https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle = driver.getWindowHandle();
        //Başlığıni "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        assertEquals("Techpro Education | Online It Courses & Bootcamps", driver.getTitle());

        //Tab 2'de https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com ");
        String youtubeWindowHandle = driver.getWindowHandle();
        assertEquals("YouTube", driver.getTitle());

        //Tab 3'te https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        //sayfa basliginin LinkedIn icerdigini kontrol ediniz
        assertTrue(driver.getTitle().contains("LinkedIn"));
        //windowHandle Set'ini bir list icine aliyoruz
        List<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandleList.get(0));
        wait(3);
        driver.switchTo().window(windowHandleList.get(1));
        wait(3);
        driver.switchTo().window(windowHandleList.get(2));
/*
        //techproeducation sayfasına geçiniz
        driver.switchTo().window(techproWindowHandle);
        //youtube sayfasına geçiniz
        driver.switchTo().window(youtubeWindowHandle);
        //linkedIn sayfasına geçiniz
        driver.switchTo().window(linkedinWindowHandle);

 */
    }
    @Test
    public void newTabTest2(){
        // https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        // Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        assertEquals("Techpro Education | Online It Courses & Bootcamps",driver.getTitle());
        //Tab 2'de https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com ");
        String youtubeWindowHandle = driver.getWindowHandle();
        assertEquals("YouTube", driver.getTitle());

        //Tab 3'te https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        //sayfa basliginin LinkedIn icerdigini kontrol ediniz
        assertTrue(driver.getTitle().contains("LinkedIn"));

        //techproeducation sayfasına geçiniz
        wait(2);
        switchToWindow(0);
        //youtube sayfasına geçiniz
        wait(2);
        switchToWindow(1);
        //linkedIn sayfasına geçiniz
        wait(2);
        switchToWindow(2);
    }


}
