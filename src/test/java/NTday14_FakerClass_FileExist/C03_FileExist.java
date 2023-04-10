package NTday14_FakerClass_FileExist;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class C03_FileExist {
    @Test
    public void fileExist() {
        //Masa ustunde bir dosya olusturalim
        //Bu dosyanin varligini dogrulayalim
        System.out.println(System.getProperty("user.dir"));
        //projemizin icinde bulundugu yolu verir ==> C:\Users\Sistem\IdeaProjects\B129_SeleniumMavenJUnit

       String userHome = System.getProperty("user.home");//Her kullanicinin ana yolu farkli oldu icin farkli ayri yazdik
        //Lokalimizdeki kullanici yolunu verir ==> C:\Users\Sistem
        String ayniYol = "/Desktop/b10 all test cases, code.docx";//Ayni yerde olusturuldugu icin ayni yol dedim
        String dosyaYolu = userHome + ayniYol; //Dosya yolu olarak farkli kisim ve ortak kisimi aldik
        boolean varMi = Files.exists(Paths.get(dosyaYolu));//Files.exist methodu ile dosyanin varligini dogruladik
        assertTrue(varMi);
    }
}
