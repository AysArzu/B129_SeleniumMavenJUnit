package NTday14_FakerClass_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class C04_FileDownloadTest extends TestBase {
    @Test
    public void fileDownloadTest() {
        //https://testcenter.techproeducation.com/index.php?page=file- adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        File silinecekDosya = new File("C:\\Users\\Sistem\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();
        /*
        Eger localinizden otomasyon ile bir dosya silmek icin File class'indan obje olusturup
        dosya yolumuzu icine yerlestiririz. olusturdugumuz obje ile delete() methodunu kullanarak o dosyayi silebiliriz
        Bunu yapme sebebimiz test classlarimizi calistirdigimizda her calistirmada yeni bir dosya create
        edecegi icin ordaki dosya kalabaligini onlemis oluruz.Ayni zamanda dogrulama isimizi garantiye almis oluruz
        Birden fazla dosya indirmis olsak ayni isimde her indirilenin yanina index verecegi icin ve
         bizim ilk indirdigimiz o klasorun icinde bulunacagi icin her zaman ilk dosyanin varligini test etmis oluruz.
         */
        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//a)[3]")).click();
        wait(4);

       //Dosyanın başarıyla indirilip indirilmediğini test edelim
        //ilk olarak dosya yolunu aliyoruz
        String dosyaYolu = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        assertTrue(Files.exists(Path.of(dosyaYolu)));
      //  "C:\Users\Sistem\Downloads\b10 all test cases, code.docx"







    }
}
