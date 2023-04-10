package NTday14_FakerClass_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class FakerClassOdevi extends TestBase {
    @Test
    public void fakerClass() {

        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        //“create new account”  butonuna basin
driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //“firstName” giris kutusuna bir isim yazin
        driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        faker.name().firstName();

        //“surname” giris kutusuna bir soyisim yazin
        faker.name().lastName();
        //“email” giris kutusuna bir email yazin
        String email = faker.internet().emailAddress();

        //“email” onay kutusuna emaili tekrar yazin

        //Bir sifre girin
        faker.number().digit();
        //Tarih icin gun secin
        faker.date().birthday();
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //Sayfayi kapatin


    }
}
