package day16_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerException  {
    WebDriver driver;
    Faker faker;
    Integer number;
    String name;
    @Test
    public void nullPointerException() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum
        //extends TestBase yapmadigimiz icin NullPointerException aliriz.
    }

    @Test
    public void nullPointerException2() {
        String name= "Ayse";
        System.out.println(name.charAt(0));
        String lastname;
       // System.out.println(lastname.charAt(0));CTE verir java kutuphane ile.
        // Lastname'e null atasakta cte olmasa da yine sari highlight yapar

        System.out.println(faker.name().firstName());//faker tanimlanmadigi icin exception aldik. null
        System.out.println(faker.number().numberBetween(1, 10));
    }

    @Test
    public void nullPointerException3() {

        System.out.println( number + 6);//java.lang.NullPointerException
    }

    @Test
    public void nullPointerException4() {
        //name="ayse"; atanmazsa java.lang.NullPointerException
        System.out.println(name.charAt(0));
    }
}
