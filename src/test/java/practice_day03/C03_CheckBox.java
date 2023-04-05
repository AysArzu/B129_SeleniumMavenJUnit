package practice_day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C03_CheckBox extends TestBase {
    // https://demo.guru99.com/test/radio.html adresine gidin
    // checkbox elementlerini locate edin
    // checkbox1 ve checkbox3  secili degil ise secin ==> birden fazla yere tik atilir
    // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
    // checkbox2 elementinin secili olmadıgını test edin
    @Test
    public void testo1() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");

        // checkbox elementlerini locate edin
        WebElement checkBox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement checkBox2 =  driver.findElement(By.id("vfb-6-1"));
        WebElement checkBox3 =   driver.findElement(By.id("vfb-6-2"));

        // checkbox1 ve checkbox3  secili degil ise secin
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }
        if(!checkBox3.isSelected()){
            checkBox3.click();
        }
        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        assertTrue(checkBox1.isSelected());
        assertTrue(checkBox3.isSelected());

        // checkbox2 elementinin secili olmadıgını test edin
        assertFalse(checkBox2.isSelected());
    }


}
