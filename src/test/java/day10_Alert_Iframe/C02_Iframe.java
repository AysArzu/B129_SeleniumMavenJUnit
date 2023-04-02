package day10_Alert_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Iframe extends TestBase {

    @Test
    public void iframe() {
        //Sinif : IFrame
        //➢ https://testcenter.techproeducation.com/index.php?page=iframe
        //➢ Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin   oldugunu test edelim
        //➢ Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //➢ Son olarak footer daki ‘Povered By’ yazisini varligini test edilip

        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        String actualText = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(actualText.contains("black border"));

        //➢ Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
        String actual = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actual, "Applications lists");
        driver.switchTo().parentFrame();// defaultContent() te olabilir.
        String poveredBy = driver.findElement(By.xpath("(//p[text()='Povered By'])")).getText();
        Assert.assertTrue(poveredBy.contains("Povered By"));
    }
 /*
        Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydim index'i 1 almam gerekicekti
        Örneğin:
            <body>
                <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe");
                    <iframe id="innerIframe" src="https://www.google.com"></iframe> -->Eğer bir üst frame içinde bir frame daha varsa tekrar driver.switchTo().frame("innerIframe");
                </iframe>
            </body>
        -Index ile yukarıda bahsettiğimiz gibide yapabilirsiniz
        -iframe'i locate ederekte örneğin yukarıdaki kodun "iframe[id='outerIframe']" ccsSelector ile locate edilmiş hali
        -id ve name attributu varsa "driver.switchTo().frame("outerIframe")" bu şekildede geçiş yapabilirsiniz
         */
}
