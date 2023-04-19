package day18_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShot extends TestBase {
    @Test
    public void webElementScreenShot() throws IOException {
        //Amazon sayfasina gidiniz
        driver.get("https://amazon.com");

        //Arama bolumunde iphone aratiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);

        //Sonuc yazisinin resmini aliniz
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='sg-col-inner']"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/WebElemetScreenShot" + tarih + ".png";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
       /*
       Sadece bir web elementin resmini almak istersek, FileUtils.copyFile() methoduyla
       locate ettigimiz web elementi getScreenshotAs() methodu kullanarak resmini alabiliriz
        */

    }


}
