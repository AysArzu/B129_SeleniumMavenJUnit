package NTday14_FakerClass_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C02_FakerClass  {
    @Test
            public void faker(){


    //1.Faker objesi olustururuz
    Faker faker = new Faker();
    //Faker.instance()methodu ile de kullanabiliriz.
    //Faker.instance() mthodu kullanabiliriz

    //Firstname yazdiralim
        System.out.println("Fake first name "+ faker.name().firstName());
        System.out.println(Faker.instance().name().firstName());
        //Lastname uazdralim
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        //Kullanici adi yazdiralim
        System.out.println("faker.name().username() = " + faker.name().username());

        //Meslek ismi
        System.out.println("faker.name().title() = " + faker.name().title());
        System.out.println("faker.job().position() = " + faker.job().position());
        //sehir ismi
        System.out.println("faker.address().city() = " + faker.address().city());
        // Ulke ismi
        System.out.println("faker.address().country() = " + faker.address().country());
        //adress yazdilarim
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        //telefon numarasi
        System.out.println("faker.phoneNumber().cellPhone() = " + faker.phoneNumber().cellPhone());

        System.out.println("faker.book().author() = " + faker.book().author());

        System.out.println("faker.address().timeZone() = " + faker.address().timeZone());

        //rastgele 15 haneli bir numara
        System.out.println("faker.number().randomDigit() = " + faker.number().randomDigit());
        System.out.println("faker.number().digits(15) = " + faker.number().digits(15));

        System.out.println("faker.internet().domainWord() = " + faker.internet().domainWord());
    }
   }