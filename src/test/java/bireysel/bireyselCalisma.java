package bireysel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class bireyselCalisma extends TestBase {
    /*
	Go to URL: https://the-internet.herokuapp.com/dropdown
	Create method selectByIndexTest and Select Option 1 using index .
	Create method selectByValueTest Select Option 2 by value.
	Create method selectByVisibleTextTest Select Option 1 value by visible text.
	Create method printAllTest Print all dropdown value.
	Verify the dropdown has Option 2 text.
	Create method printFirstSelectedOptionTest Print first selected option.
	Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
	 */

    @Test
    public void name() {


        //	Go to URL: https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");


        //	Create method selectByIndexTest and Select Option 1 using index .
        WebElement ddm = driver.findElement(By.id("dropdown"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        wait(3);

        //	Create method selectByValueTest Select Option 2 by value.
        select.selectByValue("2");
        wait(3);

        //	Create method selectByVisibleTextTest Select Option 1 value by visible text.
        select.selectByVisibleText("Option 1");
        wait(3);

        //	Create method printAllTest Print all dropdown value.
        List<WebElement> ddmValue = select.getOptions();
        ddmValue.forEach(t-> System.out.println(t.getText()));

        //	Verify the dropdown has Option 2 text.



        //	Create method printFirstSelectedOptionTest Print first selected option.
        //	Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.


    }
}