package day14_JavaFaker_FileExist;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class C03_FileExist {
    /*
Masaüstünde "logo.jpeg" dosyası oluşturun.
Bu dosyanın varlığını doğrulayın.
*/
    @Test
    public void fileExist() {

          String userDIR = System.getProperty("user.dir"); //C:\Users\Sistem\IdeaProjects\B129_SeleniumMavenJUnit
          //IDE proje yolunu dinamik olarak verir
       String  userHOME = System.getProperty("user.home");//C:/Users/Sistem (kullanici adi)
        //kullanci adi yolunu dinamiik olarak verir
        boolean isExist =  Files.exists(Paths.get(userHOME +"/Desktop/logo.jpeg"));
        System.out.println("isExist: " + isExist);
        assertTrue(isExist);
        //C:\Users\Sistem\IdeaProjects\B129_SeleniumMavenJUnit\src\test\java\day14_JavaFaker_FileExist\C03_FileExist.java

/*
        Fail ise: Dosya masaüstünde değil, dosya adı yanlış, yada arada onedrive gibi ekstra dosyalar olabilir.
         */




    }
}
