package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    /*
        === HANDLE DROPDOWN ===
Uzerinde durunca acilan menulerdeki optionslari locate etmek icin
Oncelikle menuyu locate edip
sonrasinda Select objesi olusturmaliyiz.
Objenin constructorina WebElementi yerlestiricez.

SYNTAX:
    WebElement ddm = driver.findElement(By.*)
    Select select = new Select(ddm)
*/
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void selectByIndex() {
        //1. locate Dropdown Element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        //2. Select objesi olustur
        Select yearDropDown = new Select(year);

        //3.Select objesini kullanarak 3 farkli sekilde secim yapabiliriz.
        // index(0) en yukaridaki index(1) bir altindaki seklinde gidiyor
        yearDropDown.selectByIndex(22);//2001 yili oldu

        //Ay secimi:
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select monthDropDown = new Select(month);
        monthDropDown.selectByVisibleText("August");

        //Gun secimi:
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select dayDropDown = new Select(day);
        dayDropDown.selectByVisibleText("7");


    }@Test
    public void printAll(){
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropDown = new Select(state);
        List<WebElement> stateList = stateDropDown.getOptions();
        for (WebElement each: stateList) {
            System.out.println(each.getText());
        }
        //Tavsiye edilen
        stateList.forEach(t-> System.out.println(t.getText()));//stream yazmaya gerek yok
    }
}