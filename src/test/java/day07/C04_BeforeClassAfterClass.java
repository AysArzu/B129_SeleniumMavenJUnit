package day07;

import org.junit.*;

public class C04_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass methodlari sadece static methodlar ile calisir.
     */
    @BeforeClass
    public static void setUp() {
        System.out.println("Tum testlerden once bir kere calisir");
        System.out.println("=================================");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Tum testlerden sonra bir kere calisir");
        System.out.println("=================================");
    }
    @Before
    public void setUp01() {

        System.out.println("her testten once calisir");
        System.out.println("=================================");
    }
    @After
    @Before
    public void setUp02() {

        System.out.println("her testten sonra calisir");
        System.out.println("=================================");
    }
    @Test
    public void test01() {

        System.out.println("ilk test");
        System.out.println("=================================");
    }

    @Test
    public void test02() {

        System.out.println("ikinci test");
        System.out.println("=================================");
    }

    @Test
    public void test03() {

        System.out.println("Ucuncu test");
        System.out.println("=================================");
    }


}
