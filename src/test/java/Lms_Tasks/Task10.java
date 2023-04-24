package Lms_Tasks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task10 extends TestBase {
    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;

    @Test
    public void task10() {
        extentReports = new ExtentReports();
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyy").format(new Date());
        String pathway = "TestOutput/reports/extendsReport_" + date + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(pathway);
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Ayse");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
        extentTest = extentReports.createTest("ExtentTest", "Test Raporu");

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads");
        extentTest.info("selenyum dev sayfasinin download bolumune gidildi");
        //Sayfanın resmini alalım
        tumSayfaResmi();
        extentTest.info("Tum sayfanin ekran goruntusu alindi");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("(//h2)[8]"));
        actions.moveToElement(element).perform();
        extentTest.info("Browser bolumu gorunene kadar sayfayi asagiya indridim");
        wait(3);

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("(//button[@data-toggle='collapse'])[83]")).click();
        driver.findElement(By.xpath("//a[@href='https://chromedriver.chromium.org/']")).click();
        extentTest.info("Chrome driver bölümündeki documentation linkine tikladim");
        //Documentation webelementinin resmini alalım
        tumSayfaResmi();

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        driver.findElement(By.linkText("ChromeDriver 112.0.5615.49")).click();
        String window1Handle = driver.getWindowHandle();
        extentTest.info("All versions available in Downloads altında Latest stable release olan linki tıkladim.");

        //Açılan pencerede chromedriver'i indirelim
        Set<String> windowHandles = driver.getWindowHandles();
        for (String eachHandle : windowHandles) {
            if (!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);
            }
        }
        driver.findElement(By.linkText("chromedriver_win32.zip")).click();
        wait(15);
        extentTest.info("Açılan pencerede chromedriver'i indirdim.");

        //Driver'in indiğini doğrulayalım "C:\Users\Sistem\Downloads\chromedriver_win32.zip"
        String way = System.getProperty("user.home");
        String path = way + "\\Downloads\\chromedriver_win32.zip";
        boolean isExist = Files.exists(Paths.get(path));
        assertTrue(isExist);
extentTest.info("Driver'in indiğini doğruladim.");

        //İndirmiş olduğumuz dosyayı silelim
        File dosya = new File(path);
        dosya.delete();
extentTest.info("İndirmiş olduğumuz dosyayı sildim");

        //Silindiğini doğrulayalım
        assertFalse(Files.exists(Path.of(path)));
extentTest.info("Dosyanin silindigini dogruladim");

        extentTest.pass("test sonlandırıldı");

        extentReports.flush();

        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)

    }
}
