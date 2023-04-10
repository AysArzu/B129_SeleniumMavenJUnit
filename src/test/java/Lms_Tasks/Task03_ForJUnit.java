package Lms_Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task03_ForJUnit {
    /*
    -BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    -Before methodunda http://www.google.com adresine gidin
    -Üç farklı test methodu ile;
    -arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    -arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    -arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    -NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
    -AfterClass ile kapatın
     */
    static WebDriver driver;

    @BeforeClass
    public static void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Before
    public void setUp() {
        //-Before methodunda http://www.google.com adresine gidin
        driver.get("http://www.google.com");

    }

    @After
    public void tearDown() {

        String[] sonuc = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("Arama Sonuc Sayısı = " + sonuc[1]);
    }

    @AfterClass
    public static void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();


    }

    // -arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test01() throws InterruptedException {

        driver.findElement(By.xpath("//div[text()='Alles accepteren']")).click();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Lord of the Rings" + Keys.ENTER);

    }

    //-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test02() throws InterruptedException {

        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("The God Father" + Keys.ENTER);

    }

    //-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test03() throws InterruptedException {

        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Kill Bill" + Keys.ENTER);

    }
}
