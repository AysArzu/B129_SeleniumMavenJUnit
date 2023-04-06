package AutomationExercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Task11 extends TestBase {
    @Test
    public void test01() {
        ////2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        ////1. Launch browser


        ////3. Verify that home page is visible successfully
        String title = driver.getTitle();
        assertTrue(title.contains("Automation"));

        ////4. Click 'Cart' button
        driver.findElement(By.linkText("Cart")).click();
        ////5. Scroll down to footer
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);

        ////6. Verify text 'SUBSCRIPTION'
        WebElement element = driver.findElement(By.xpath("//h2"));
        assertTrue(element.isDisplayed());

        ////7. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("istanbul@evim.com"+Keys.ENTER);

        ////8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement result = driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
        assertTrue(result.isDisplayed());
    }


}
