package NTday07_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test oncesi bir kez calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test sonrasi bir kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("Ikinci test");
    }
}
