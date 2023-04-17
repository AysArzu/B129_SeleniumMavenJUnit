package bireysel;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ScreenshotsOfEntirePage extends TestBase {
    @Test
    public void takeScreenShotTest() throws IOException {
        //Given user search for 'uni'
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        //Take a screenshot create a reusable method and call that method
      //  takeScreenshotOfPage();

        //Select United Kingdom
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        //Select the "United Kingdom" from the suggestions

        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
        wait(2);
       // takeScreenshotOfPage();

        //Click on submit button
        driver.findElement(By.cssSelector("input[type='button']")).click();
        wait(2);
      //  takeScreenshotOfPage();

        //Verify the result contains United Kingdom
        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        assertTrue(result.contains("United Kingdom"));
        wait(2);
      //  takeScreenshotOfPage();

    }
}
