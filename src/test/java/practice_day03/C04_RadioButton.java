package practice_day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C04_RadioButton extends TestBase {

    // https://demo.guru99.com/test/radio.html adresine gidin
    // radiobutton elementlerini locate edin
    // option2'yi secin
    // option2 elementlerinin secili oldugunu Test edin
    // option1 elementlerinin secili olmadıgını test edin
    // option3 elementlerinin secili olmadıgını test edin

    @Test
    public void test01() {
        // https://demo.guru99.com/test/radio.html adresine gidin

        driver.get("https://demo.guru99.com/test/radio.html");

        // radiobutton elementlerini locate edin
        WebElement radioButton1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radioButton2 = driver.findElement(By.id("vfb-7-2"));
        WebElement radioButton3 = driver.findElement(By.id("vfb-7-3"));

        // option2'yi secin
        radioButton2.click();

        // option2 elementlerinin secili oldugunu Test edin
        assertTrue(radioButton2.isSelected());
        // option1 elementlerinin secili olmadıgını test edin
        assertFalse(radioButton1.isSelected());
        // option3 elementlerinin secili olmadıgını test edin
        assertFalse(radioButton3.isSelected());

    }
}
