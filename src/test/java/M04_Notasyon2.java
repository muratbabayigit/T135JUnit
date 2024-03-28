import org.junit.*;

public class M04_Notasyon2 {
    /*
        @BeforeClass ---> Tüm testler çalıştırılmadan önce 1 kere çalışır
        @AfterClass ----> Tüm testler bittikten sonra 1 kere çalışır
        @Before  -------> Her bir testten önce 1 keree çalışır
        @After  --------> Her bir testten sonra 1 kere çalışır
     */

    @BeforeClass
    public static void before(){
        System.out.println("Testler çalıştırılmaya başlanıyor");
    }

    @AfterClass
    public static void after(){
        System.out.println("Testlerin çalıştırılması tamamlandı");
    }

    @Before
    public void setUp(){
        System.out.println("Sıradaki test çalıştırılıyor");
    }

    @After
    public void tearDown(){
        System.out.println("Testin çalıştırılması bitti. Sırada test varsa ona geçiliyor");
    }

    @Test
    public void test01(){
        System.out.println("İlk Test çalıştırılıyor");
    }
    @Test
    public void test02(){
        System.out.println("İinci test çalıştırılıyor");
    }
}
