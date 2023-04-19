package practice_day05;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
public class C02_Files {
    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

    @Test
    public void test01() {
        //    "C:\Users\Sistem\Desktop\text"
        String farkiKisim = System.getProperty("user.home");//"C:\Users\Sistem
        System.out.println(farkiKisim);
        String ayniKisim = "\\Desktop\\text";
        System.out.println(ayniKisim); //\Desktop\text"
        String dosyaYolu = farkiKisim + ayniKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}