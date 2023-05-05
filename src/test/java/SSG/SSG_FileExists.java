package SSG;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class SSG_FileExists extends TestBase {
    @Test
    public void fileExists() {

        //"C:\Users\Sistem\Desktop\ILK CASE.xlsx"
        String path = "C:/Users/Sistem/Desktop/ILK CASE.xlsx";
        assertTrue(Files.exists(Paths.get(path)));
    }

    @Test
    public void fileExistsTest2() {
        String userHome= System.getProperty("user.home");
       String ortakYol="/Desktop/ILK CASE.xlsx";
       assertTrue(Files.exists(Paths.get(userHome+ortakYol)));
    }

    @Test
    public void fileExistsTest3() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/download.html");
        String userHome= System.getProperty("user.home");
        String dosyaYolu = userHome+ "/Downloads/webdrivermanager.png";
        File silinecekDosya = new File(dosyaYolu);
        silinecekDosya.delete();
        driver.findElement(By.xpath("//*[text()='WebDriverManager logo']")).click();
        wait(5);
        userHome= System.getProperty("user.home");
      dosyaYolu = userHome+ "/Downloads/webdrivermanager.png";

        assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
