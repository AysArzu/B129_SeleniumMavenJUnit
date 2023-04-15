package Ntday17_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    @Test
    public void screenShotTest() throws IOException {
/*
            Tüm ekran görüntüsünü Selenium'dan gelen getScreenShotAs methodu ile alırız.
        Bu method selenium'daki TakesScreenshot arayüz'ünden(interface) gelir
         */
        //Techproeducation sayfasına gidelim

        driver.get("https://techproeducation.com");
// 1.Adimilk olarak ekran resmini alacagimiz dosyayi nereye kaydedecegimizi belirtiriz
        // Proje seviyesinden new directory deyip resim dosyalarimizi bu klasorun icine kaydetsin.

        String path = "test-output/screenShot.png";


        //2.Adim TakeScreenShot arayuzunden obje olusturmak
        TakesScreenshot ts = (TakesScreenshot) driver;
        //3.adim
        /*
            FileUtils class'ı file nesneleri ile birlikte kullanabileceğimiz methodlar içerir.
        Bu methodları kullanarak dosyalarda okuma, yazma, kopyalama ve silme işlemlerini çok daha kolay yapabiliriz
        NOT: Files.write() methodu'da aynı işlemi görür
         */

        //Ekran resmini projemize kaydedelim
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(path));


    }

    @Test
    public void screenShotTest2() throws IOException {
        driver.get("https://amazon.com");
String tarih =  new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = " test-output/screenShot" + tarih + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }


}

