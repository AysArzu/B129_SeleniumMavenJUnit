package day14_JavaFaker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class C04_FileDownloadTest extends TestBase {
    @Test
    public void fileDownload() {
        /*
 "https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
 "b10 all test cases" dosyasını indirin
  Dosyanın başarıyla indirilip indirilmediğini test edin.

 */
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        driver.findElement(By.linkText("b10 all test cases, code.docx")).click();
        wait(3);
        String userHome = System.getProperty("user.home");

        String filePath = userHome + "/Downloads/b10 all test cases, code.docx";
        boolean isExist = Files.exists(Path.of(filePath));
        assertTrue(isExist);

    }
    /*
    HOCANIN KODLARI
        @Test
    public void fileDownloadTest(){
//        "https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

//        "b10 all test cases" dosyasını indirin
        driver.findElement(By.linkText("b10 all test cases, code.docx")).click();
        bekle(2);

//        Dosyanın başarıyla indirilip indirilmediğini test edin.
        String filePath = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
                                  //C:\Users\TechProEd

        boolean isExist = Files.exists(Path.of(filePath));
        assertTrue(isExist);
    }
     */
}
