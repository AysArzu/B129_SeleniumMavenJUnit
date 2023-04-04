package day12_WindowHandle_BasicAuth;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void basicAuth() {
/*kimlik dogrulama yontemidir.
         Asagidki bilgilerini kullanarak authentication yapiniz
        url      : https://the-internet.herokuapp.com/basic_auth sitesine gidiniz
        username : admin
        password : admin
        basarili girisi dogrulayiniz
 */
        // Authentication Url : https://admin:admin@url
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        wait(3);
        //Paragrafin Congratulations! icerdigini test edin
        assertTrue(driver.findElement(By.xpath("//p")).getText().contains("Congratulations!"));
    }
}
