package bireysel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class FileUploadTest extends TestBase {
    @Test
    public void fileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");
        //Locate choose file and click choose a file
        WebElement chooseAFileButton = driver.findElement(By.id("file-upload"));
        wait(3);

        //select a file from your computer
        String userHome = System.getProperty("user.home");
        String pathOfFile = userHome + "\\Desktop\\qa.png";

        //Sending the path of the file that I want to upload.
        //We can use sendKeys cause the input type file combination
        chooseAFileButton.sendKeys(pathOfFile);
        wait(3);
        //then locate and click upload
        driver.findElement(By.id("file-submit")).click();

        //Then verify the "File Uploaded!" message displayed
        WebElement msg = driver.findElement(By.xpath("//h3"));
        msg.isDisplayed();

        //OR
        String message = driver.findElement(By.xpath("//h3")).getText();
        boolean isEqual = message.equals("File Uploaded!");
        assertTrue(isEqual);
        /*
            HOW DO YOU UPLOAD A FILE WITH SELENIUM?
            FIRST:Selenium has limitation automation of files.But file upload can be done with can be done with selenium.
            We locate the chose file button and use sendKeys function to send the path of the file.
            Then we click upload button to upload the file.
            Path of the file should be dynamic. Use System.getProperty("user.home");

        LIMITATION:
        Selenium has limitation automation DESKTOP APPS
        For example, we can not find path of files, or verify if file exists on out machines with selenium
        Instead we use java File libraries.

         */


    }
}
