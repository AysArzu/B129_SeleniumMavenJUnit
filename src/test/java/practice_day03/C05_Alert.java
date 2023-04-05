package practice_day03;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_Alert extends TestBase {
    //http://demo.guru99.com/test/delete_customer.php adresine gidin
    //customer id kısmına 53920 yazın
    //submit butonuna tıklayın
    //cıkan alert mesajını yazdırın
    //alerti kabul edin
    //cıkan 2. alert mesajını yazdırın
    //cıkan 2. alerti kabul edin
    @Test
    public void test01() {
        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        //customer id kısmına 53920 yazın
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("53920");

        //submit butonuna tıklayın
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        wait(2);
        //cıkan alert mesajını yazdırın
        System.out.println(driver.switchTo().alert().getText());
        wait(2);
        //alerti kabul edin
        driver.switchTo().alert().accept();
        wait(2);
        //cıkan 2. alert mesajını yazdırın
        driver.switchTo().alert().getText();
        wait(2);
        //cıkan 2. alerti kabul edin
        driver.switchTo().alert().accept();

    }
}
