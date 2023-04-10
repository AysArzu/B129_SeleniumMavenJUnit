package bireysel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class UploadFile extends TestBase {
    @Test
    public void uploadFile() throws IOException {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        wait(3);
        //chooseFile butonuna basalim
      WebElement load = driver.findElement(By.xpath("//input[@id='file-upload']"));
        wait(3);
        //Yuklemek istediginiz dosyayi secelim.
       String userHome = System.getProperty("user.home");
       String userDIR = userHome + "/Desktop/qa.png";
       load.sendKeys(userDIR);
       wait(3);

        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
