package day15_FileUpload_Wait;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C01_FileUpload extends TestBase {

    @Test
    public void fileUpload() {
        /*
    https://the-internet.herokuapp.com/upload adresine gidin
    logo.jpeg dosyasını yükleyin(upload)
    “File Uploaded!” textinin görüntülendiğini test edin
    */        //C:\Users\Sistem\Desktop\logo.jpeg

          /*
        Bir Web sayfasında upload işlemi yapmamız gerekirse;
            1-Öncelikle upload edeceğimiz webelementi locate ederiz
            2-Upload edeceğimiz dosya yolunu bir string'e assign ederiz
            3-Locate ettiğimiz webelement'e sendkeys() methodu ile dosyayolunu aldığımız string değişkeni göndeririz
         */
        driver.get("https://the-internet.herokuapp.com/upload");
        String userHome = System.getProperty("user.home");
        System.out.println(userHome);
        String path = userHome +"/Desktop/logo.jpeg";
                driver.findElement(By.id("file-upload")).sendKeys(path);
                wait(3);
                driver.findElement(By.id("file-submit")).click();
        WebElement yazi = driver.findElement(By.xpath("//h3"));
        assertTrue(yazi.isDisplayed());
    }
}
