package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

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
        driver.close();
    }
    //HARD WAIT METHOD
    public static void wait(int second)  {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //ALERT ACCEPT
    public static void alertAccept(){
        driver.switchTo().alert().accept();
    }
    //ALERT DISMISS
    public static void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }
    //ALERT GETTEXT()

    public static void alertText(){
        driver.switchTo().alert().getText();
    }
    //ALERT PROMPTBOX
    public static void alertprompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */

    public static void ddmVisibleText(WebElement ddm, String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }
    //DROPDOWN INDEX
    public static void ddmIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    public static void ddmValue(WebElement ddm,String secenek){
        Select select= new Select(ddm);
        select.selectByValue(secenek);
    }
}
