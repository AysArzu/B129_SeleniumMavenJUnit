package practice_day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v109.overlay.model.LineStyle;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class C02_DropDownOptions extends TestBase {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın
    @Test
    public void test01() {
        driver.get("https://www.amazon.com/");
        // dropdown'dan "Baby" secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        System.out.println(select.getFirstSelectedOption().getText());

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> optionsList = select.getOptions();
        int optionsNum = select.getOptions().size();
        System.out.println(optionsNum);
        assertEquals(optionsNum,28);

        // dropdown'daki optionların tamamını yazdırın
       optionsList.forEach(t-> System.out.println(t.getText()));
    }
    /*
    HOCANIN COZUMU
    @Test
    public void name() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");


        // dropdown'dan "Baby" secenegini secin

        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select = new Select(ddm);
        select.selectByVisibleText("Baby");


        // sectiginiz option'i yazdirin
        String sectigimOption = select.getFirstSelectedOption().getText();
        System.out.println("SECTİGİM OPTİON: " + sectigimOption);



        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> optionlarList = select.getOptions();

        int expectedOptionSayisi = 28;
        int actuelOptionSayisi = optionlarList.size();
        Assert.assertEquals(expectedOptionSayisi,actuelOptionSayisi);

        // dropdown'daki optionların tamamını yazdırın

        int sayac=1;

        for (WebElement each:optionlarList) {
            System.out.println(sayac + ". option: " + each.getText());
            sayac++;
        }

    }
}
     */
}
