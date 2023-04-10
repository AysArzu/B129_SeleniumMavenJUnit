package bireysel;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OdevAmazonGiftCard extends TestBase {
    @Test
    public void giftCard() {
        // 2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // 3- Browseri tam sayfa yapin

        // 4.- Sayfayi "refresh" yapin
        driver.navigate().refresh();

        // 5. Sayfa basliginin "Spend less" ifadesi icerdigini test edin
        String title = driver.getTitle();
        assertTrue(title.contains("Spend less"));
        // 6. Gift Cards sekmesine basin
        driver.findElement(By.linkText("Gift Cards")).click();

        // 7. Birthday butonuna basin
        driver.findElement(By.linkText("Birthday")).click();

        // 8.  Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//img[@alt='Amazon.com eGift Card']")).click();
        // 9. Gift card details'den 25 $'i secin
        driver.findElement(By.xpath("//button[@id='gc-mini-picker-amount-1']")).click();

        // 10-Urun ucretinin 25$ oldugunu test edin

        String fiyat = driver.findElement(By.xpath("//span[@id='gc-live-preview-amount']")).getText();
        assertEquals(fiyat,"$25.00");

    }
}
