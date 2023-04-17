package bireysel;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class AutoComplete extends TestBase {
    @Test
    public void autoComplete() {
        //Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

        driver.findElement(By.id("myCountry")).sendKeys("tur");

        //Select the "Turkey" from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='Turkey']")).click();
        wait(3);
        //Click on submit button
        driver.findElement(By.cssSelector("input[type='button']")).click();

        //Verify the result contains "Turkey"
        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        assertTrue(result.contains("Turkey"));
    }


}
