package SSG;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class SSG_JSExecutorTest1 extends TestBase {

    @Test
    public void jsExecuter() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement text = (WebElement) js.executeScript("return document.getElementById('content');");//Hello Shadow DOM
        System.out.println(text.getText());
        Assert.assertEquals("Hello Shadow DOM",text.getText());
    }
}
