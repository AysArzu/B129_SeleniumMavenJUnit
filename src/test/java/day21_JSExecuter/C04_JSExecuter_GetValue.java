package day21_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecuter_GetValue extends TestBase {
    //  1)getValueTest metotu olustur
    // 2)https://www.carettahotel.com/ a git
    //  3)Tarih kısmındaki Yazili metinleri al ve yazdıriniz


    @Test
    public void getValueTest() {
        driver.get("https://www.carettahotel.com/");
        //Clickler ile guvenlik duvarini astik.
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

        //  3)Tarih kısmındaki Yazili metinleri al ve yazdır
        getValueByJS("checkin_date","value");
    }
}
