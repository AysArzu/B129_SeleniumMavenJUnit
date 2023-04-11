package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C01_FileUpload extends TestBase {
    /*
https://the-internet.herokuapp.com/upload adresine gidin
logo.jpeg dosyasını yükleyin(upload)
"File Uploaded!" textinin görüntülendiğini test edin
*/
//"C:\Users\Sistem\Desktop\qa.png"
    @Test
    public void upload() {
        driver.get("https://the-internet.herokuapp.com/upload");
        String anaYol = System.getProperty("user.home");
        String tumYol = anaYol + "\\Desktop\\qa.png";
        //String tumYol = anaYol + "/Desktop/qa.png";
        driver.findElement(By.id("file-upload")).sendKeys(tumYol);
        //Gönerilecek(upload) dosyanın adresini choosefile butununa sendKeys() metodu ile yazıyoruz.
        // Bu şekilde gödrilecek dosya seçilmiş olur.
        wait(3);
        driver.findElement(By.id("file-submit")).click();

        WebElement fileUploadedText = driver.findElement(By.xpath("//h3"));
        assertTrue(fileUploadedText.isDisplayed());


    }
}
