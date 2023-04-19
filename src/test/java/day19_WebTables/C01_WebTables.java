package day19_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

//    https://the-internet.herokuapp.com/tables sayfasına gidin
//    Task 1 : Table1’i yazdırın
//    Task 2 : 3. Satır verilerini yazdırın
//    Task 3 : Son satirin verilerini yazdırın
//    Task 4 : 5. Sütun verilerini yazdırın
//    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
//    Parameter 1 = satır numarası
//    Parameter 2 = sütun numarası
//    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.


    //    Task 1 : Table1’i yazdırın
    @Test
    public void table1Print() {
        driver.get(" https://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.id("table1")).getText();
        System.out.println("Table1:");
        System.out.println(table1);
        //Elementleri tek tek yazdiralim
        List<WebElement> tumElementler = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement w : tumElementler) {
            System.out.println(w.getText());
        }
        //Lambda ile
        tumElementler.forEach(t -> System.out.println(t.getText() + " ==> "));
    }

    @Test
    public void satir3VerileriPrint() {
        //    Task 2 : 3. Satır verilerini yazdırın
        driver.get(" https://the-internet.herokuapp.com/tables");
        List<WebElement> satirUcList = driver.findElements(By.xpath("//table[@id='table1']//tr[3]/td"));
        satirUcList.forEach(t -> System.out.print(t.getText() + " | "));
    }

    @Test
    public void sonSatirVerileri() {
        //    Task 3 : Son satirin verilerini yazdırın
        driver.get(" https://the-internet.herokuapp.com/tables");
        List<WebElement> sonSatirList = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[last()]"));
        //last() ==> bu methodla son satirin indexini alabiliyoruz
        sonSatirList.forEach(t -> System.out.print(t.getText() + " | "));
        //--/td dersem table datalari verir. sonuna td koymazsam tum satiri alir.
    }

    @Test
    public void sutun5Verileri() {
        //    Task 4 : 5. Sütun verilerini yazdırın
        driver.get(" https://the-internet.herokuapp.com/tables");
        List<WebElement> sutun5List = driver.findElements(By.xpath("//table[@id='table1']//td[5]"));
        sutun5List.forEach(t -> System.out.print(t.getText() + " | "));
        //td[5] ile sutun aldik
        //tr ile satir aliyoruz
    }


    public void printData(int satir, int sutun) {
        // Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

        driver.get(" https://the-internet.herokuapp.com/tables");
        WebElement belirliVeri = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+satir+"]/td["+sutun+"]"));
        System.out.println(belirliVeri.getText());
    }

    @Test
    public void printDataTest() {
        printData(2,3);//fbach@yahoo.com

        printData(3,5);// http://www.jdoe.com
    }
}
