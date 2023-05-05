package practice_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import java.util.Set;
public class C01_ActionMoveToElement extends TestBase {
    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mouse'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
    @Test
    public void test01() throws InterruptedException {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String sayfa1Handle = driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mouse'u bu menunun ustune getirelim
        WebElement dilMenusu = driver.findElement(By.xpath("//div[text()='EN']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dilMenusu).perform();
        Thread.sleep(3000);

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();
        Thread.sleep(3000);

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        Thread.sleep(3000);
        /*
            Drop down option listesi 'Go to website' butonuna basmamıza engel oldugu icin
            herhangi bir yere click yapıp drop down option listesinin toparlanmasını sagladık
         */
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();

        // driver.findElement(By.xpath("//a[@id='icp-dropdown_18']")).click();
        Thread.sleep(3000);

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
        Thread.sleep(3000);

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        Set<String> windowHandlesSeti = driver.getWindowHandles();
        System.out.println("TUM SAYFALARIN HANDLE DEGERLERİ: " + windowHandlesSeti);
        System.out.println("SAYFA1HANDLE: " + sayfa1Handle);
        String sayfa2Handle="";
        for (String each:windowHandlesSeti) {
            if(!each.equals(sayfa1Handle)){
                sayfa2Handle=each;
            }
        }
        System.out.println("SAYFA2HANDLE: " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle); // driver'i sayfa2'ye gecirdik
        String ikinciSayfaTitle = driver.getTitle();
        System.out.println("İKİNCİ SAYFA TITLE: " + ikinciSayfaTitle);
        Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));
    }
}
