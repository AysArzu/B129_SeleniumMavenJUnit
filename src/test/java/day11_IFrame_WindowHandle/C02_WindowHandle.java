package day11_IFrame_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_WindowHandle extends TestBase {
    /*
        https://the-internet.herokuapp.com/windows adresine gidin.
        İlk sayfanın ID'sini alın.
        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        "Click Here" butonuna tıklayın.
        Açılan pencereye geçin.
        Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        2. pencereye tekrar geçin.
        1. pencereye tekrar dönün.
         */
    @Test
    public void windowHandle() {
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //    İlk sayfanın ID'sini alın.
        String window1Handle = driver.getWindowHandle();

        //    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement yazi = driver.findElement(By.xpath("//h3[.='Opening a new window']"));
        yazi.isDisplayed();
        //    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String title = driver.getTitle();
        Assert.assertEquals("The Internet",title);
        //    "Click Here" butonuna tıklayın.
        driver.findElement(By.linkText("Click Here")).click();
        //    Açılan pencereye geçin.
        //Bu safhada 2 pencere acik. 2. pencereye gecis yapiyorum
        Set<String> allWindowHandles =driver.getWindowHandles();
        for(String eachHandle :allWindowHandles ){
            if(!eachHandle.equals(window1Handle)){
                driver.switchTo().window(eachHandle);
            }
        }
        //    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
            String window2handle = driver.getTitle();
        Assert.assertEquals("New Window",window2handle);

        //    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(window1Handle);
       Assert.assertEquals("The Internet", driver.getTitle());
        //    2. pencereye tekrar geçin.
        driver.switchTo().window(window2handle);
        //    1. pencereye tekrar dönün.
        driver.switchTo().window(window2handle);
    }


}
