package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public abstract class TestBase {
    //TestBase class'indan obje olusturmanin onune gecilmesi icin abstract yapilabilir
//Orn: TestBase base=new TestBase();
//Bu class'a extend ettigimiz test classlarinda ulasabiliriz.
    protected static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        wait(3);
      //  driver.close();
    }

    //HARD WAIT METHOD
    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //ALERT ACCEPT
    public static void alertAccept() {
        driver.switchTo().alert().accept();
    }

    //ALERT DISMISS
    public static void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }
    //ALERT GETTEXT()

    public static void alertText() {
        driver.switchTo().alert().getText();
    }

    //ALERT PROMPTBOX
    public static void alertprompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */

    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DROPDOWN INDEX
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DROPDOWN VALUE
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitchTo:Sayfalar arasi gecis methodu
    //Index 0 dan baslar
    //Girilen indexteki windowHandle degerini alarak o sayfaya gecis yapar.
    public static void switchToWindow(int sayfaIndexi) {
        List<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandleList.get(sayfaIndexi));

    }//SwitchToWindow2

    public static void window(int sayi) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
    }

    //AUTO COMPLETE REUSABLE METHOD
    //THIS CODE IS USED FOR SELECTION AND VERIFYING OUR APP AUTO COMPLETE SEARCH FUNCTIONALITY
    public static void searchAndSelectFromList(String keyword, String textFromList) {

        //Sending a Keyword dynamically using parameter1
        driver.findElement(By.id("myCountry")).sendKeys(keyword);
        wait(4);
        //Selecting an option from the list Dynamically using parameter2
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='" + textFromList + "']")).click();
        //Nothing special.Just clicking on submit button
        wait(3);
        driver.findElement(By.xpath("//input[@type='button']")).click();
        //Verifying if result contains the option that I selected dynamically using parameter.
        wait(3);
        assertTrue(driver.findElement(By.id("result")).getText().contains(textFromList));
    }

    //TAKE SCREENSHOT OF ENTIRE PAGE WITH THIS REUSABLE METHOD
    public void takeScreenshotOfPage() throws IOException {
        //1.Take screenshot using getScreenshotAs(OutputType.FILE); Screenhot is a FILE
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //2.Save the screenhot in a path and Save with dynamic name
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting the current local date

        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";//Where we save the image
        //3.Saving the IMAGE in the Path
        FileUtils.copyFile(image,new File(path) );
    }

}
