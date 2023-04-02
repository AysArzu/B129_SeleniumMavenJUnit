package day09_DropDown_Allerts;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    @Test
    public void test01(){
        //Techproeducation sayfasina gidelim.
        driver.get("https://techproedication.com");

        //Basligin "Bootcamp" icerdigini test edelim.
        String actualTitle = driver.getTitle();
        String expectedTitle="Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
