package day21_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

/*
    Techpro education ana sayfasına git
    We Offer elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
    Aynı sayfada Enroll Free elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada WHY US? elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada tekrar Enroll Free elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
 */
public class C02_JSExecuter_Scroll extends TestBase {
    @Test
    public void JSExecuterScrollTest() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapattik

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("//span[text()='we offer']"));
        //testbase e bunlari method olarak  yazdik
        // JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("arguments[0].scrollIntoView(true);", weOffer);
        scrollIntoView(weOffer);
        tumSayfaResmi();
        wait(2);

        //Aynı sayfada Enroll Free elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.linkText("Enroll Free Course"));
        scrollIntoView(enrollFree);
        tumSayfaResmi();
        wait(3);

        //Aynı sayfada WHY US? elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//h3[text()='WHY US?']"));
        scrollIntoView(whyUs);
        tumSayfaResmi();
        wait(3);

        //Aynı sayfada tekrar Enroll Free elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        scrollIntoView(enrollFree);
        tumSayfaResmi();

        //Sayfayi en alta kaydir.
        //Method yaptik
        //  JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        scrollEndJS();
        wait(3);
        //Sayfayi en uste kaydir.
        //Method yaptik
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        scrollTopJS();

    }
}
