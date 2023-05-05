package Lms_Tasks;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Objects;

public class Task12 extends TestBase {
    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
    //Sonucu konsola yazdırıp
    //Sonucun doğrulamasını yapalım

    @Test
    public void task12() {

        // Hesap makinası sayfasına git
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        // Random sayılar oluştur
        Faker faker = new Faker();
        int num1 = Integer.parseInt(faker.number().digits(2));
        int num2 = Integer.parseInt(faker.number().digits(2));

        System.out.println(num1);
        System.out.println(num2);
        String[] numA = (num1 + "").split("");
        String[] numB = (num2 + "").split("");

        // Sayıları ve işlemi hesap makinasına gir

        //BIRINCI SAYIYI HESAP MAKINASINA GIRDIM
        for (int i = 0; i <= 9; i++) {
            if (Objects.equals(numA[0], i + "")) {
                driver.findElement(By.xpath("//span[text()='" + i + "" + "']")).click();

            }
            if (Objects.equals(numA[1], i + "")) {
                driver.findElement(By.xpath("//span[text()='" + i + "" + "']")).click();
            }
        }
        int operation = faker.number().numberBetween(0, 4); // 0-3 arasında random sayi aldik
        System.out.println(operation);

        // YAPACAGIM ISLEMI HESAP MAKINASINA GIRDIM
        switch (operation) {
            case 0 -> driver.findElement(By.xpath("//span[text()='+']")).click();
            case 1 -> driver.findElement(By.xpath("//span[text()='-']")).click();
            case 2 -> driver.findElement(By.xpath("//span[text()='x']")).click();
            case 3 -> driver.findElement(By.xpath("//span[text()='÷']")).click();
        }
        //IKINCI SAYIYI HESAP MAKINASINA GIRDIM
        for (int i = 0; i <= 9; i++) {
            if (Objects.equals(numB[0], i + "")) {
                driver.findElement(By.xpath("//span[text()='" + i + "" + "']")).click();

            }
            if (Objects.equals(numB[1], i + "")) {
                driver.findElement(By.xpath("//span[text()='" + i + "" + "']")).click();
            }
        }
        //SONUCU BULMAK ICIN ESITTIR'E BASTIM
        driver.findElement(By.xpath("//span[text()='=']")).click();
        wait(5);

        // Sonucu konsola yazdır
        WebElement result = driver.findElement((By.xpath("//div[@class='screen']")));
        System.out.println(result.getText());

        // DOGRULAMAYI YAPIYORUM
        int actualResult = Integer.parseInt(result.getText());
        int expected = switch (operation) {
            case 0 -> num1 + num2;
            case 1 -> num1 - num2;
            case 2 -> num1 * num2;
            default -> num1 / num2;
        };
        System.out.println(actualResult);
        System.out.println(expected);
        if (actualResult == expected) {
            System.out.println("Doğrulama başarılı!");
        } else {
            System.out.println("Doğrulama başarısız!");
        }

        // WebDriver'ı kapat
        driver.quit();
    }

}

