import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M05 {
    static WebDriver driver;
    WebElement searchBox;
    String film;

    /*
        BeforeClass ile driver'i oluşturun ve class icinde static yapin
        Maximize edin ve 10 sn bekletin
        her biri için https://www.gooqle.com adresine gidin
        1-arama kutusuna "12 Angry Men” yazip, cikan sonuc sayisini yazdirin
        2-arama kutusuna "Vizontele” yazip, cikan sonuc sayisini yazdirin
        3-arama kutusuna "Saving Private Ryan” yazip, cikan sonuc sayisini yazdirin
        AfterClass ile kapatin.
     */

    @BeforeClass
    public static void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Before
    public void before(){
        driver.get("https://www.google.com");
       // searchBox= driver.findElement(By.xpath("//*[@id='APjFqb']"));
        searchBox = driver.findElement(By.id("APjFqb"));
    }

    @After
    public void after(){

        System.out.println(film+" aramasında bulunan sonuç sayısı: "+driver.findElement(By.id("result-stats")).getText());

    }


    @Test
    public void test01(){
        film="12 Angry Men";
        searchBox.sendKeys(film+ Keys.ENTER);
    }
    @Test
    public void test02(){
        film="Vizontele";
        searchBox.sendKeys(film+ Keys.ENTER);
    }
    @Test
    public void test03(){
        film="Saving Private Ryan";
        searchBox.sendKeys(film+ Keys.ENTER);
    }
    @Test
    public void test04(){
        film="Esaretin Bedeli";
        searchBox.sendKeys(film+ Keys.ENTER);
    }
    @Test
    public void test05(){
        film="3 Idiots";
        searchBox.sendKeys(film+ Keys.ENTER);
    }


}
