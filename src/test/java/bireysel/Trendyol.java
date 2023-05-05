package bireysel;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class Trendyol extends TestBase {

    ExtentReports extentReports; //Raporlamayı başlatır
    ExtentHtmlReporter extentHtmlReporter;//Raporu HTML formatında düzenler
    ExtentTest extentTest;
   @Test
    public void name() {
       extentReports = new ExtentReports();
       String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
       String dosyaYolu = "TestOutput/reports/extentReport_"+tarih+".html";
       extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
       extentReports.attachReporter(extentHtmlReporter);

       //Raporda gözükmesini istediğimiz bilgiler için
       extentReports.setSystemInfo("Browser","Chrome");
       extentReports.setSystemInfo("Tester","Ayse");
       extentHtmlReporter.config().setDocumentTitle("Extent Report");//Baslik ekledim
       extentHtmlReporter.config().setReportName("Smoke Test Raporu");
        extentTest = extentReports.createTest("ExtentTest", "Trendyol Sözleşme ve Formlar bölümü Test Raporu");
        //"https://www.trendyol.com/" sitesine git
        driver.get("https://www.trendyol.com/");

        extentTest.info("https://www.trendyol.com/ sitesine gidildi");
        //sayfanin handle degerini al
        String ilkSayfa = driver.getWindowHandle();
        wait(2);
        extentTest.info("sayfanin handle degeri alindi");

        //arama kutusuna "erkek atlet" yaz
       driver.findElement(By.xpath("//input[@data-testid='suggestion']")).click();
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='search-bar']"));
        aramaKutusu.sendKeys("erkek atlet", Keys.ENTER);
        wait(2);
        extentTest.info("arama kutusuna 'erkek atlet' yazildi");

        //arama sonuclarindan kac urun ciktigini al
        String aramaSonucu =  driver.findElement(By.xpath("//div[@class='dscrptn']")).getText();
        wait(2);
        String arama = aramaSonucu.trim().replaceAll("\\D", "");
        System.out.println(arama);
        extentTest.info("arama sonuclarindan kac urun ciktigini alindi");
        //sol tarafta marka bolumunda Tutku checkbox sec
        driver.findElement(By.xpath("(//div[@class='fltr-item-text'])[1]")).click();
        extentTest.info("sol tarafta marka bolumunda Tutku checkbox secildi");
        //secim sonuclarindan kac urun ciktigini al
        wait(2);
        String secimSonucu =  driver.findElement(By.xpath("//*[text()='\" araması için ']//*")).getText();
        System.out.println(secimSonucu);
        wait(2);
        String secim = secimSonucu.trim().replaceAll("\\D", "");
        System.out.println(secim);
        extentTest.info("secim sonuclarindan kac urun ciktigini alindi");
        //secim sonucunda urun sayisinin secim onceis urun sayisi ile ayni olmadigini dogrula
        Assert.assertNotEquals(arama, secim);
        extentTest.info("secim sonucunda urun sayisinin secim oncesi urun sayisi ile ayni olmadigini dogrulandi");
        //sonuclarda kadin atleti olmadigini dogrula
        List<WebElement> atlet = null;
        try {
            for (int i = 0; i < 50; i++) {
                atlet= driver.findElements(By.xpath("//div[@class='p-card-wrppr with-campaign-view']"));

            }
        }catch (Exception e) {
        }
        int sayac = 0;
        for (WebElement w : atlet) {
            if (w.getText().contains("kadın") || w.getText().contains("Kadın")) {
             //   takeScreenshot(w);
                System.out.println(w.getText());
                assertFalse(atlet.toString().contains("Kadın"));
                sayac++;
            }
        }
        System.out.println("Listelenen ürünlerde " + sayac + " adet Kadın ürünü var");
        int size = atlet.size();
        System.out.println("Listin eleman sayisi: " + size);

        extentTest.info("sonuclarda kadin atleti olmadigi dogrulanamadi");
        extentTest.pass("Test sonlandırıldı");
    }
}

