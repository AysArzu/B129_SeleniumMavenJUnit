package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions03 extends TestBase {
    /*
https://techproeducation.com adresine gidin
Sayfanın alt tarafına gidin
Sayfanın üst tarafına gidin
*/
    @Test
    public void name() {
        //https://techproeducation.com adresine gidin


        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("(//i[@class='eicon-close'])")).click();

        //Sayfanın alt tarafına gidin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//ARROW_DOWN tusu PAGE_DOWN tusundan daha az asagi kaldirir
        wait(3);

        //Sayfanın üst tarafına gidin
        actions.sendKeys(Keys.PAGE_UP).perform();

        /*       Sayfanın alt tarafına gidin

//        bekle(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        bekle(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        bekle(2);
//        actions.sendKeys(Keys.ARROW_DOWN).perform();//ARROW_DOWN tuşu PAGE_DOWN tuşundan daha az aşağıya kaydırıyor
//        bekle(2);
//        actions.sendKeys(Keys.ARROW_DOWN).perform();

        wait(3);
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                build().
                perform();

//        Sayfanın üst tarafına gidin
        wait(3);
        actions.sendKeys(Keys.PAGE_UP).perform();
        wait(3);
        actions.sendKeys(Keys.ARROW_UP).perform();
*/
    }
}
